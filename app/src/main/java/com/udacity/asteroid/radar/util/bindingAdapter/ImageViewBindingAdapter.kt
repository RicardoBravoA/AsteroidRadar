package com.udacity.asteroid.radar.util.bindingAdapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import com.udacity.asteroid.radar.R
import com.udacity.asteroid.radar.data.util.isInternet

@BindingAdapter("imageUrl")
fun ImageView.bindImage(url: String?) {

    url?.let {
        Picasso.get()
            .load(url)
            .error(R.drawable.ic_no_photo)
            .into(this)
        scaleType = if (context.isInternet()) {
            ImageView.ScaleType.CENTER_CROP
        } else {
            ImageView.ScaleType.CENTER_INSIDE
        }

    }
}

@BindingAdapter("statusIcon")
fun ImageView.bindAsteroidStatusImage(isHazardous: Boolean) {
    if (isHazardous) {
        setImageResource(R.drawable.ic_status_potentially_hazardous)
    } else {
        setImageResource(R.drawable.ic_status_normal)
    }
}

@BindingAdapter("asteroidStatusImage")
fun ImageView.bindDetailsStatusImage(isHazardous: Boolean) {
    if (isHazardous) {
        setImageResource(R.drawable.asteroid_hazardous)
    } else {
        setImageResource(R.drawable.asteroid_safe)
    }
}