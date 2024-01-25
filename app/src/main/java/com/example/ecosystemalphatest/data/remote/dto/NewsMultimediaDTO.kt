package com.example.ecosystemalphatest.data.remote.dto

import com.example.ecosystemalphatest.domain.models.NewsMultimedia

data class NewsMultimediaDTO(
    val caption: String,
    val copyright: String,
    val format: String,
    val height: Int,
    val subtype: String,
    val type: String,
    val url: String,
    val width: Int
)

fun NewsMultimediaDTO.toNewsMultimedia() = NewsMultimedia(
    caption = caption,
    height = height,
    url = url,
    width = width
)