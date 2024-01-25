package com.example.ecosystemalphatest.data.remote.dto

import com.example.ecosystemalphatest.domain.models.NewsArticle

data class NewsArticleDTO(
    val abstract: String,
    val byline: String,
    val created_date: String,
    val des_facet: List<String>,
    val geo_facet: List<String>,
    val item_type: String,
    val kicker: String,
    val material_type_facet: String,
    val multimedia: List<NewsMultimediaDTO>,
    val org_facet: List<String>,
    val per_facet: List<String>,
    val published_date: String,
    val section: String,
    val short_url: String,
    val subsection: String,
    val title: String,
    val updated_date: String,
    val uri: String,
    val url: String
)

fun NewsArticleDTO.toNewsArticle() = NewsArticle(
    published_date = published_date,
    title = title,
    abstract = abstract,
    multimedia = multimedia.map{ it.toNewsMultimedia() },
    uri = uri,
    url = url,
    byline = byline
)