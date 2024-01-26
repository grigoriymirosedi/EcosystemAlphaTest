package com.example.ecosystemalphatest.data.remote.api

import com.example.ecosystemalphatest.BuildConfig
import com.example.ecosystemalphatest.data.remote.dto.NewsResponseDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface NewYorkTimesAPI {

    @GET("world.json")
    suspend fun getAllTopStories(
        @Query("api-key") newsApiKey: String
    ): Response<NewsResponseDTO>

}