package com.udacity.asteroid.radar.data.mapper

import com.udacity.asteroid.radar.data.entity.PictureResponse
import com.udacity.asteroid.radar.data.storage.entity.PictureEntity
import com.udacity.asteroid.radar.domain.model.PictureModel

object PictureMapper {

    fun transformResponseToEntity(pictureResponse: PictureResponse): PictureEntity {
        return PictureEntity(
            pictureResponse.url,
            pictureResponse.mediaType,
            pictureResponse.title,
            pictureResponse.date,
            pictureResponse.explanation
        )
    }

    fun transformEntityToModel(pictureEntity: PictureEntity): PictureModel {
        return PictureModel(
            pictureEntity.url,
            pictureEntity.mediaType,
            pictureEntity.title,
            pictureEntity.date,
            pictureEntity.explanation
        )
    }

    fun transformResponseToModel(pictureResponse: PictureResponse): PictureModel {
        return PictureModel(
            pictureResponse.url,
            pictureResponse.mediaType,
            pictureResponse.title,
            pictureResponse.date,
            pictureResponse.explanation
        )
    }

}