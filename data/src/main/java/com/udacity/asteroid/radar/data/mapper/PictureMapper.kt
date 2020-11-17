package com.udacity.asteroid.radar.data.mapper

import com.udacity.asteroid.radar.data.entity.PictureResponse
import com.udacity.asteroid.radar.data.storage.entity.PictureEntity
import com.udacity.asteroid.radar.domain.model.PictureModel

object PictureMapper {

    fun transformResponseToEntity(pictureResponse: PictureResponse): PictureEntity {
        return PictureEntity(
            pictureResponse.copyright,
            pictureResponse.date,
            pictureResponse.explanation,
            pictureResponse.title,
            pictureResponse.url,
            pictureResponse.mediaType
        )
    }

    fun transformEntityToModel(pictureEntity: PictureEntity): PictureModel {
        return PictureModel(
            pictureEntity.copyright,
            pictureEntity.date,
            pictureEntity.explanation,
            pictureEntity.title,
            pictureEntity.url,
            pictureEntity.mediaType
        )
    }

    fun transformResponseToModel(pictureResponse: PictureResponse): PictureModel {
        return PictureModel(
            pictureResponse.copyright,
            pictureResponse.date,
            pictureResponse.explanation,
            pictureResponse.title,
            pictureResponse.url,
            pictureResponse.mediaType
        )
    }

    fun transformModelToResponse(pictureModel: PictureModel): PictureResponse {
        return PictureResponse(
            pictureModel.copyright,
            pictureModel.date,
            pictureModel.explanation,
            pictureModel.title,
            pictureModel.url,
            pictureModel.mediaType
        )
    }

}