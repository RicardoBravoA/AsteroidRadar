package com.udacity.asteroid.radar.data.entity

import com.squareup.moshi.Json

data class PictureResponse(
    val url: String,
    @Json(name = "media_type")
    val mediaType: String,
    val title: String,
    val date: String,
    val explanation: String
)