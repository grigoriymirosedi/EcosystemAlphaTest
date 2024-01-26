package com.example.ecosystemalphatest.data.repository

import com.example.ecosystemalphatest.BuildConfig
import com.example.ecosystemalphatest.data.remote.api.NewYorkTimesAPI
import com.example.ecosystemalphatest.data.remote.dto.NewsResponseDTO
import com.example.ecosystemalphatest.domain.repository.NewsRepository
import retrofit2.Response

class NewsRepositoryImpl(private val newsApi: NewYorkTimesAPI): NewsRepository {
    override suspend fun getAllNews(): Response<NewsResponseDTO> {
        return newsApi.getAllTopStories(newsApiKey = BuildConfig.NEW_YORK_TIMES_API_KEY)
    }
}