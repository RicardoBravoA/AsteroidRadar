package com.udacity.asteroid.radar.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.udacity.asteroid.radar.databinding.ItemDetailBinding
import com.udacity.asteroid.radar.databinding.ItemDetailPictureBinding
import com.udacity.asteroid.radar.util.bindingAdapter.bindDetailsStatusImage
import com.udacity.asteroid.radar.util.bindingAdapter.show

class DetailAdapter(private val helpClick: () -> Unit) :
    ListAdapter<DetailModel, RecyclerView.ViewHolder>(DiffCallback) {

    enum class Type {
        PICTURE, ITEM
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            Type.PICTURE.ordinal -> PictureHolder.from(parent)
            Type.ITEM.ordinal -> {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemDetailBinding.inflate(layoutInflater, parent, false)

                return ItemViewHolder(binding, helpClick)
            }
            else -> throw ClassCastException("Unknown viewType $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is PictureHolder -> {
                val picture = getItem(position) as DetailModel.Picture
                holder.bind(picture)
            }
            is ItemViewHolder -> {
                val item = getItem(position) as DetailModel.Item
                holder.bind(item.detailItem)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is DetailModel.Picture -> Type.PICTURE.ordinal
            is DetailModel.Item -> Type.ITEM.ordinal
        }
    }

    class ItemViewHolder(
        private var binding: ItemDetailBinding,
        private val helpClick: () -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(detailItem: com.udacity.asteroid.radar.domain.model.DetailItem) {
            binding.titleTextView.text = detailItem.title
            binding.descriptionTextView.text = detailItem.subTitle
            binding.helpImageView.show(detailItem.showIcon)

            binding.helpImageView.setOnClickListener {
                helpClick()
            }
        }
    }

    class PictureHolder(private var binding: ItemDetailPictureBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(picture: DetailModel.Picture) {
            binding.potentialImageView.bindDetailsStatusImage(picture.isPotentiallyHazardous)
        }

        companion object {
            fun from(parent: ViewGroup): RecyclerView.ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemDetailPictureBinding.inflate(layoutInflater, parent, false)

                return PictureHolder(binding)
            }
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<DetailModel>() {
        override fun areItemsTheSame(oldItem: DetailModel, newItem: DetailModel): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: DetailModel, newItem: DetailModel): Boolean {
            return oldItem.id == newItem.id
        }
    }

}
