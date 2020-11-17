package com.udacity.asteroid.radar.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PictureOfTheDayModel(
    val copyright: String, val date: String, val explanation: String,
    val title: String, val url: String, val mediaType: String
) : Parcelable