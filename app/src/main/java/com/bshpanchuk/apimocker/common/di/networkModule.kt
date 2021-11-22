package com.bshpanchuk.apimocker.common.di

import com.bshpanchuk.apimocker.data.remote.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    factory { provideLogger() }
    factory { provideOkHttpClient(get()) }
    factory { provideApi(get()) }

    single { provideRetrofit(get()) }
}

private fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

private fun provideLogger() : HttpLoggingInterceptor {
    return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC)
}

private fun provideOkHttpClient(httpLogInt: HttpLoggingInterceptor): OkHttpClient {
    return OkHttpClient()
        .newBuilder()
        .addInterceptor(httpLogInt)
        .build()
}

private fun provideApi(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

const val BASE_URL = "https://jsonplaceholder.typicode.com/"