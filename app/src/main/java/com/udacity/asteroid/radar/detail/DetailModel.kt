package com.udacity.asteroid.radar.detail

import com.udacity.asteroid.radar.domain.model.DetailItem

sealed class DetailModel {
    data class Item(val detailItem: com.udacity.asteroid.radar.domain.model.DetailItem) : DetailModel() {
        override val id = Long.MIN_VALUE
    }

    data class Picture(val isPotentiallyHazardous: Boolean) :
        DetailModel() {
        override val id = Long.MIN_VALUE
    }

    abstract val id: Long
}