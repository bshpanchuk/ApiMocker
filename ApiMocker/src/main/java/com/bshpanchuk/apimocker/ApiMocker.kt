package com.bshpanchuk.apimocker

import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.reflect.KSuspendFunction1
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

/**
 *  Using to mock HTTP request
 */
object ApiMocker {

    /**
     *  @param body - the body (json text) you want in return,
     *  @param code - HTTP codes response,
     *  @param delayTime - delay response,
     *  @param apiFunction - your ApiService function (so far only without parameters),
     */
    suspend inline fun <reified T: Any, R> mockResponse(
        body: String,
        code: Int,
        delayTime: Long,
        apiFunction: KSuspendFunction1<T, R>,
    ) : R = withContext(IO){
        val mockServer = MockWebServer().apply {
            start()
            enqueue(MockResponse().setResponseCode(code).setBody(body))
        }

        val baseUrl = mockServer.url("").toUrl().toString()

        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val testService = retrofit.create(T::class.java)

        delay(delayTime)

        return@withContext apiFunction(testService)
    }
}