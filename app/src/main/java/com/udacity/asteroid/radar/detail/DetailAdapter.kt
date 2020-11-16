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

class DetailAdapter(private val helpClick: () -> Unit) :
    ListAdapter<DetailItem, DetailAdapter.DetailViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        val binding: ItemDetailBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.item_detail, parent, false
        )
        return DetailViewHolder(binding, helpClick)
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class DetailViewHolder(
        private var binding: ItemDetailBinding,
        private val helpClick: () -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(detailItem: DetailItem) {
            binding.titleTextView.text = detailItem.title
            binding.descriptionTextView.text = detailItem.subTitle
            binding.helpImageView.show(detailItem.showIcon)

            binding.helpImageView.setOnClickListener {
                helpClick()
            }

        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<DetailModel>() {
        override fun areItemsTheSame(oldItem: DetailModel, newItem: DetailModel): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: DetailModel, newItem: DetailModel): Boolean {
            return oldItem.title == newItem.title
        }
    }

}
