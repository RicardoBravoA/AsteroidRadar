package com.udacity.asteroid.radar.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.udacity.asteroid.radar.R
import com.udacity.asteroid.radar.databinding.ItemDetailBinding
import com.udacity.asteroid.radar.model.DetailItem
import com.udacity.asteroid.radar.util.bindingAdapter.show

class DetailAdapter : ListAdapter<DetailItem, DetailAdapter.DetailViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        val binding: ItemDetailBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.item_detail, parent, false
        )
        return DetailViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class DetailViewHolder(private var binding: ItemDetailBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(detailItem: DetailItem) {
            binding.titleTextView.text = detailItem.title
            binding.descriptionTextView.text = detailItem.subTitle
            binding.helpImageView.show(detailItem.showIcon)
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<DetailItem>() {
        override fun areItemsTheSame(oldItem: DetailItem, newItem: DetailItem): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: DetailItem, newItem: DetailItem): Boolean {
            return oldItem.title == newItem.title
        }
    }

}
