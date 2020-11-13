package com.udacity.asteroid.radar.util.bindingAdapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.udacity.asteroid.radar.main.MainAdapter
import com.udacity.asteroid.radar.main.MainItem
import com.udacity.asteroid.radar.model.Asteroid

@BindingAdapter("asteroidData")
fun RecyclerView.bindRecyclerView(data: List<MainItem>?) {
    val recyclerAdapter = adapter as MainAdapter
    recyclerAdapter.submitList(data)
    setHasFixedSize(false)
}

@BindingAdapter("adapter")
fun RecyclerView.bindRecyclerViewAdapter(adapter: RecyclerView.Adapter<*>) {
    setHasFixedSize(true)
    this.adapter = adapter
}