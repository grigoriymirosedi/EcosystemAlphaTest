package com.example.ecosystemalphatest.domain.repository

import com.example.ecosystemalphatest.data.remote.api.NewYorkTimesAPI
import com.example.ecosystemalphatest.data.remote.dto.NewsArticleDTO
import com.example.ecosystemalphatest.data.remote.dto.NewsResponseDTO
import retrofit2.Response

interface NewsRepository {

    suspend fun getAllNews(): Response<NewsResponseDTO>
}