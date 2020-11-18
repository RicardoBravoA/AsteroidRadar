package com.udacity.asteroid.radar.mapper

import com.udacity.asteroid.radar.domain.model.AsteroidModel
import com.udacity.asteroid.radar.domain.model.PictureModel
import com.udacity.asteroid.radar.main.MainItem

object MainMapper {

    fun transform(items: List<AsteroidModel>, picture: PictureModel?): List<MainItem> {
        val list = mutableListOf<MainItem>()
        picture?.let {
            list.add(MainItem.Picture(it.url, it.mediaType, it.title))
        }

        items.forEach {
            list.add(MainItem.Item(it))
        }
        return list
    }


}