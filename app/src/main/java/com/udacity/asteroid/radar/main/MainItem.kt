package com.udacity.asteroid.radar.main

import com.udacity.asteroid.radar.model.AsteroidModel

sealed class MainItem {
    data class Item(val asteroidModel: AsteroidModel) : MainItem() {
        override val id = asteroidModel.id
    }

    data class Picture(val url: String, val type: String) :
        MainItem() {
        override val id = Long.MIN_VALUE
    }

    abstract val id: Long
}