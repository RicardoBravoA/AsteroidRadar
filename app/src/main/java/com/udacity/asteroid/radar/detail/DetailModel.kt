package com.udacity.asteroid.radar.detail

import com.udacity.asteroid.radar.model.DetailItem

sealed class DetailModel {
    data class Item(val detailItem: DetailItem) : DetailModel() {
        override val id = Long.MIN_VALUE
    }

    data class Picture(val url: String) :
        DetailModel() {
        override val id = Long.MIN_VALUE
    }

    abstract val id: Long
}