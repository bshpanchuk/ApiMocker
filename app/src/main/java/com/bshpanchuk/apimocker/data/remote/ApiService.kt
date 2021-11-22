package com.bshpanchuk.apimocker.data.remote

import com.bshpanchuk.apimocker.data.model.PostItem
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    suspend fun getPosts() : List<PostItem>
}