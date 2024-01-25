package com.example.ecosystemalphatest.domain.models

data class NewsArticle(
    val published_date: String,
    val title: String,
    val abstract: String,
    val multimedia: List<NewsMultimedia>,
    val uri: String,
    val url: String,
    val byline: String,
)