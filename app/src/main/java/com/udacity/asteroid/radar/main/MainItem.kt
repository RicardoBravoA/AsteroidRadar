package com.udacity.asteroid.radar.main

import com.udacity.asteroid.radar.model.Asteroid

sealed class MainItem {
    data class Item(val asteroid: Asteroid) : MainItem() {
        override val id = asteroid.id
    }

    data class Picture(val url: String) :
        MainItem() {
        override val id = Long.MIN_VALUE
    }

    abstract val id: Long
}