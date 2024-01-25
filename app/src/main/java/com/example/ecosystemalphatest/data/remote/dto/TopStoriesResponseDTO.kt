package com.example.ecosystemalphatest.data.remote.dto

data class TopStoriesResponseDTO(
    val copyright: String,
    val last_updated: String,
    val num_results: Int,
    val results: List<TopStoriesArticleDTO>,
    val section: String,
    val status: String
)