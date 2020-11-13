package com.udacity.asteroid.radar.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ImageOfTheDay(
    val copyright: String, val date: String, val explanation: String,
    val title: Double, val url: Double
) : Parcelable