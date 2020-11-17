package com.udacity.asteroid.radar.mapper

import com.udacity.asteroid.radar.database.entity.PictureOfTheDayEntity
import com.udacity.asteroid.radar.model.PictureOfTheDayModel

object PictureOfTheDayMapper {

    fun transformEntityToModel(pictureOfTheDayEntity: PictureOfTheDayEntity): PictureOfTheDayModel {
        return PictureOfTheDayModel(
            pictureOfTheDayEntity.copyright,
            pictureOfTheDayEntity.date,
            pictureOfTheDayEntity.explanation,
            pictureOfTheDayEntity.title,
            pictureOfTheDayEntity.url,
            pictureOfTheDayEntity.mediaType
        )
    }

    fun transformModelToEntity(pictureOfTheDayModel: PictureOfTheDayModel): PictureOfTheDayEntity {
        return PictureOfTheDayEntity(
            pictureOfTheDayModel.copyright,
            pictureOfTheDayModel.date,
            pictureOfTheDayModel.explanation,
            pictureOfTheDayModel.title,
            pictureOfTheDayModel.url,
            pictureOfTheDayModel.mediaType
        )
    }

}