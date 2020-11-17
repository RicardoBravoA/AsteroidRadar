package com.udacity.asteroid.radar.util.bindingAdapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.udacity.asteroid.radar.main.MainAdapter
import com.udacity.asteroid.radar.main.MainItem

@BindingAdapter("asteroidData")
fun RecyclerView.bindRecyclerView(data: List<MainItem>?) {
    val recyclerAdapter = adapter as MainAdapter
    recyclerAdapter.submitList(data)
    setHasFixedSize(true)
}