package com.udacity.asteroid.radar.data.mapper

import com.udacity.asteroid.radar.data.entity.PictureOfTheDayResponse
import com.udacity.asteroid.radar.data.storage.entity.PictureEntity
import com.udacity.asteroid.radar.domain.model.PictureModel

object PictureMapper {

    fun transformResponseToEntity(pictureOfTheDayResponse: PictureOfTheDayResponse): PictureEntity {
        return PictureEntity(
            pictureOfTheDayResponse.copyright,
            pictureOfTheDayResponse.date,
            pictureOfTheDayResponse.explanation,
            pictureOfTheDayResponse.title,
            pictureOfTheDayResponse.url,
            pictureOfTheDayResponse.mediaType
        )
    }

    fun transformResponseToModel(pictureOfTheDayResponse: PictureOfTheDayResponse): PictureModel {
        return PictureModel(
            pictureOfTheDayResponse.copyright,
            pictureOfTheDayResponse.date,
            pictureOfTheDayResponse.explanation,
            pictureOfTheDayResponse.title,
            pictureOfTheDayResponse.url,
            pictureOfTheDayResponse.mediaType
        )
    }

    fun transformModelToResponse(pictureModel: PictureModel): PictureOfTheDayResponse {
        return PictureOfTheDayResponse(
            pictureModel.copyright,
            pictureModel.date,
            pictureModel.explanation,
            pictureModel.title,
            pictureModel.url,
            pictureModel.mediaType
        )
    }

}