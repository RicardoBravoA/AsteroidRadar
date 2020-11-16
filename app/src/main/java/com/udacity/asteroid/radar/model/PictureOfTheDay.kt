package com.udacity.asteroid.radar.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PictureOfTheDay(
    val copyright: String, val date: String, val explanation: String,
    val title: String, val url: String, @Json(name = "media_type") val mediaType: String
) : Parcelable