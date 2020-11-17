package com.udacity.asteroid.radar.util.bindingAdapter

import android.view.View
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import com.udacity.asteroid.radar.util.NetworkStatus

@BindingAdapter("showProgressBar")
fun ProgressBar.showProgressBar(status: NetworkStatus?) {
    when (status) {
        NetworkStatus.LOADING -> {
            visibility = View.VISIBLE
        }
        NetworkStatus.ERROR -> {
            visibility = View.GONE
        }
        NetworkStatus.DONE -> {
            visibility = View.GONE
        }
    }
}