package com.udacity.asteroid.radar.util

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.udacity.asteroid.radar.R
import com.udacity.asteroid.radar.main.MainAdapter
import com.udacity.asteroid.radar.model.Asteroid

@BindingAdapter("statusIcon")
fun bindAsteroidStatusImage(imageView: ImageView, isHazardous: Boolean) {
    if (isHazardous) {
        imageView.setImageResource(R.drawable.ic_status_potentially_hazardous)
    } else {
        imageView.setImageResource(R.drawable.ic_status_normal)
    }
}

@BindingAdapter("asteroidStatusImage")
fun bindDetailsStatusImage(imageView: ImageView, isHazardous: Boolean) {
    if (isHazardous) {
        imageView.setImageResource(R.drawable.asteroid_hazardous)
    } else {
        imageView.setImageResource(R.drawable.asteroid_safe)
    }
}

@BindingAdapter("astronomicalUnitText")
fun bindTextViewToAstronomicalUnit(textView: TextView, number: Double) {
    val context = textView.context
    textView.text = String.format(context.getString(R.string.astronomical_unit_format), number)
}

@BindingAdapter("kmUnitText")
fun bindTextViewToKmUnit(textView: TextView, number: Double) {
    val context = textView.context
    textView.text = String.format(context.getString(R.string.km_unit_format), number)
}

@BindingAdapter("velocityText")
fun bindTextViewToDisplayVelocity(textView: TextView, number: Double) {
    val context = textView.context
    textView.text = String.format(context.getString(R.string.km_s_unit_format), number)
}

@BindingAdapter("asteroidData")
fun RecyclerView.bindRecyclerView(data: List<Asteroid>?) {
    val recyclerAdapter = adapter as MainAdapter
    recyclerAdapter.submitList(data)
    setHasFixedSize(true)
}

@BindingAdapter("adapter")
fun RecyclerView.bindRecyclerViewAdapter(adapter: RecyclerView.Adapter<*>) {
    setHasFixedSize(true)
    this.adapter = adapter
}

@BindingAdapter("networkStatus")
fun ImageView.bindNetworkStatus(status: NetworkStatus?) {
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
            visibility = View.GONE
        }
    }
}

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