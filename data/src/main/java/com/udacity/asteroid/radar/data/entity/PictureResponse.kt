package com.udacity.asteroid.radar.data.entity

import com.squareup.moshi.Json

data class PictureResponse(
    val copyright: String, val date: String, val explanation: String,
    val title: String, val url: String, @Json(name = "media_type") val mediaType: String
)