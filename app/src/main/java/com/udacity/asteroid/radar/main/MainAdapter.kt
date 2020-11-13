package com.udacity.asteroid.radar.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.udacity.asteroid.radar.R
import com.udacity.asteroid.radar.databinding.ItemMainBinding
import com.udacity.asteroid.radar.model.Asteroid
import com.udacity.asteroid.radar.util.bindingAdapter.show

class MainAdapter(private val asteroidClick: (asteroid: Asteroid) -> Unit) :
    ListAdapter<Asteroid, MainAdapter.MainViewHolder>(DiffCallback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val binding: ItemMainBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.item_main, parent, false
        )
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val asteroid = getItem(position)
        holder.itemView.setOnClickListener {
            asteroidClick(asteroid)
        }
        holder.bind(asteroid)
    }

    class MainViewHolder(private var binding: ItemMainBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(asteroid: Asteroid) {
            binding.titleTextView.text = asteroid.codename
            binding.descriptionTextView.text = asteroid.closeApproachDate
            binding.statusImageView.show(asteroid.isPotentiallyHazardous)
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Asteroid>() {
        override fun areItemsTheSame(oldItem: Asteroid, newItem: Asteroid): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Asteroid, newItem: Asteroid): Boolean {
            return oldItem.id == newItem.id
        }
    }

}
