package com.udacity.asteroid.radar.main

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.udacity.asteroid.radar.R
import com.udacity.asteroid.radar.databinding.ItemMainBinding
import com.udacity.asteroid.radar.model.Asteroid

class MainAdapter : ListAdapter<Asteroid, MainAdapter.MainViewHolder>(DiffCallback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(ItemMainBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val asteroid = getItem(position)
        holder.itemView.setOnClickListener {
            Log.i("z- click", asteroid.toString())
        }
        holder.bind(asteroid)
    }

    class MainViewHolder(private var binding: ItemMainBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(asteroid: Asteroid) {
            binding.titleTextView.text = asteroid.codename
            binding.descriptionTextView.text = asteroid.closeApproachDate

            if (asteroid.isPotentiallyHazardous) {
                binding.statusImageView.setBackgroundResource(R.drawable.ic_status_potentially_hazardous)
            } else {
                binding.statusImageView.setBackgroundResource(R.drawable.ic_status_normal)
            }
//            binding.property = marsProperty
            // This is important, because it forces the data binding to execute immediately,
            // which allows the RecyclerView to make the correct view size measurements
//            binding.executePendingBindings()
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
