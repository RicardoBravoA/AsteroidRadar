package com.udacity.asteroid.radar.util.bindingAdapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import com.udacity.asteroid.radar.R

@BindingAdapter("imageUrl")
fun ImageView.bindImage(url: String?) {

    url?.let {
        Picasso.get()
            .load(url)
            .error(R.drawable.ic_no_photo)
            .into(this)
        scaleType = ImageView.ScaleType.CENTER_CROP
    }
}