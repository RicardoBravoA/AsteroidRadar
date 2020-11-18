package com.udacity.asteroid.radar.data.storage.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "picture")
data class PictureEntity(
    @PrimaryKey
    val url: String,
    val mediaType: String,
    val title: String,
    val date: String,
    val explanation: String
)