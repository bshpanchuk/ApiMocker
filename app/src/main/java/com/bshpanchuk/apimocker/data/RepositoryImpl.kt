package com.bshpanchuk.apimocker.data

import com.bshpanchuk.apimocker.ApiMocker
import com.bshpanchuk.apimocker.data.model.PostItem
import com.bshpanchuk.apimocker.data.remote.ApiService
import com.bshpanchuk.apimocker.domain.Repository

class RepositoryImpl(
    private val apiService: ApiService
) : Repository {

    override suspend fun getData(): List<PostItem> {
        return ApiMocker.mockResponse(mockBody, 200, 1000, ApiService::getPosts)
       // return apiService.getPosts()
    }

    private val mockBody = "[\n" +
            "  {\n" +
            "    \"userId\": 1,\n" +
            "    \"id\": 1,\n" +
            "    \"title\": \"ApiMocker\",\n" +
            "    \"body\": \"ApiMocker\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"userId\": 1,\n" +
            "    \"id\": 2,\n" +
            "    \"title\": \"ApiMocker\",\n" +
            "    \"body\": \"ApiMocker\\nsequi sint nihil reprehenderit dolor beatae ea dolores neque\\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\\nqui aperiam non debitis possimus qui neque nisi nulla\"\n" +
            "  }\n" +
            "]"
}