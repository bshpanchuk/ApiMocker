package com.bshpanchuk.apimocker.domain

import com.bshpanchuk.apimocker.data.model.PostItem

interface Repository {

    suspend fun getData() : List<PostItem>

}