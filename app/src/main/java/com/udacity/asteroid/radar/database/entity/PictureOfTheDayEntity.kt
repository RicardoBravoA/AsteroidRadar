package com.udacity.asteroid.radar.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PictureOfTheDayEntity(
    @PrimaryKey
    val copyright: String,
    val date: String,
    val explanation: String,
    val title: String,
    val url: String,
    val mediaType: String
)