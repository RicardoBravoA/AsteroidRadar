package com.udacity.asteroid.radar.data.mapper

import com.udacity.asteroid.radar.data.entity.PictureOfTheDayResponse
import com.udacity.asteroid.radar.domain.model.PictureOfTheDayModel

object PictureOfTheDayMapper {

    fun transformResponseToModel(pictureOfTheDayResponse: PictureOfTheDayResponse): PictureOfTheDayModel {
        return PictureOfTheDayModel(
            pictureOfTheDayResponse.copyright,
            pictureOfTheDayResponse.date,
            pictureOfTheDayResponse.explanation,
            pictureOfTheDayResponse.title,
            pictureOfTheDayResponse.url,
            pictureOfTheDayResponse.mediaType
        )
    }

    fun transformModelToResponse(pictureOfTheDayModel: PictureOfTheDayModel): PictureOfTheDayResponse {
        return PictureOfTheDayResponse(
            pictureOfTheDayModel.copyright,
            pictureOfTheDayModel.date,
            pictureOfTheDayModel.explanation,
            pictureOfTheDayModel.title,
            pictureOfTheDayModel.url,
            pictureOfTheDayModel.mediaType
        )
    }

}