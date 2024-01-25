package com.example.ecosystemalphatest.data.remote.api

import com.example.ecosystemalphatest.BuildConfig
import com.example.ecosystemalphatest.data.remote.dto.NewsResponseDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface NewYorkTimesAPI {

    @Headers("api-key:" + BuildConfig.NEW_YORK_TIMES_API_KEY)
    @GET("world.json")
    suspend fun getAllTopStories(): Response<NewsResponseDTO>

}