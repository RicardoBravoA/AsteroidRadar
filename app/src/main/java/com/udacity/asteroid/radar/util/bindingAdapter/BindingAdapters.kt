package com.udacity.asteroid.radar.util.bindingAdapter

import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.udacity.asteroid.radar.R
import com.udacity.asteroid.radar.util.NetworkStatus

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

