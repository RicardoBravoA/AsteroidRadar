package com.udacity.asteroid.radar.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.udacity.asteroid.radar.R
import com.udacity.asteroid.radar.databinding.ItemMainBinding
import com.udacity.asteroid.radar.databinding.ItemPictureOfTheDayBinding
import com.udacity.asteroid.radar.model.Asteroid
import com.udacity.asteroid.radar.util.bindingAdapter.bindImage

class MainAdapter(private val asteroidClick: (asteroid: Asteroid) -> Unit) :
    ListAdapter<MainItem, RecyclerView.ViewHolder>(DiffCallback) {

    enum class Type {
        PICTURE, ITEM
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            Type.PICTURE.ordinal -> PictureHolder.from(parent)
            Type.ITEM.ordinal -> ItemViewHolder.from(parent)
            else -> throw ClassCastException("Unknown viewType $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is PictureHolder -> {
                val picture = getItem(position) as MainItem.Picture
                holder.bind(picture)
            }
            is ItemViewHolder -> {
                val item = getItem(position) as MainItem.Item
                holder.itemView.setOnClickListener {
                    asteroidClick(item.asteroid)
                }
                holder.bind(item.asteroid)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is MainItem.Picture -> Type.PICTURE.ordinal
            is MainItem.Item -> Type.ITEM.ordinal
        }
    }

    class ItemViewHolder(private var binding: ItemMainBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(asteroid: Asteroid) {
            binding.titleTextView.text = asteroid.codename
            binding.descriptionTextView.text = asteroid.closeApproachDate
            if (asteroid.isPotentiallyHazardous) {
                binding.statusImageView.setImageResource(R.drawable.ic_status_potentially_hazardous)
            } else {
                binding.statusImageView.setImageResource(R.drawable.ic_status_normal)
            }
        }

        companion object {
            fun from(parent: ViewGroup): RecyclerView.ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemMainBinding.inflate(layoutInflater, parent, false)

                return ItemViewHolder(binding)
            }
        }
    }

    class PictureHolder(private var binding: ItemPictureOfTheDayBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(picture: MainItem.Picture) {
            binding.imageOfTheDay.bindImage(picture.url)
        }

        companion object {
            fun from(parent: ViewGroup): RecyclerView.ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemPictureOfTheDayBinding.inflate(layoutInflater, parent, false)

                return PictureHolder(binding)
            }
        }
    }


    companion object DiffCallback : DiffUtil.ItemCallback<MainItem>() {
        override fun areItemsTheSame(oldItem: MainItem, newItem: MainItem): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: MainItem, newItem: MainItem): Boolean {
            return oldItem.id == newItem.id
        }
    }

}