package com.example.ecosystemalphatest.data.remote.dto

data class NewsResponseDTO(
    val copyright: String,
    val last_updated: String,
    val num_results: Int,
    val results: List<NewsArticleDTO>,
    val section: String,
    val status: String
)