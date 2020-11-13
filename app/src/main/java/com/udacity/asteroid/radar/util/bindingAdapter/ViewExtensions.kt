package com.udacity.asteroid.radar.util.bindingAdapter

import android.view.View

fun View.show(value: Boolean = true) {
    visibility = if (value) {
        View.VISIBLE
    } else {
        View.GONE
    }
}