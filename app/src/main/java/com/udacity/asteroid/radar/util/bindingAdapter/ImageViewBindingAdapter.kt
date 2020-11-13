package com.udacity.asteroid.radar.util.bindingAdapter

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import com.udacity.asteroid.radar.R
import com.udacity.asteroid.radar.util.NetworkStatus

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

@BindingAdapter("imageNetworkStatus")
fun ImageView.bindNetworkStatus(status: NetworkStatus?) {
    scaleType = ImageView.ScaleType.CENTER_INSIDE
    when (status) {
        NetworkStatus.LOADING -> {
            visibility = View.VISIBLE
            setImageResource(R.drawable.animation_loading)
        }
        NetworkStatus.ERROR -> {
            visibility = View.VISIBLE
            setImageResource(R.drawable.ic_no_photo)
        }
        NetworkStatus.DONE -> {
            visibility = View.VISIBLE
        }
    }
}