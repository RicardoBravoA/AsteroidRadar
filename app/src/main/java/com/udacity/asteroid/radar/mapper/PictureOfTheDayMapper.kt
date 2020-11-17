package com.udacity.asteroid.radar.mapper

import com.udacity.asteroid.radar.data.storage.entity.PictureOfTheDayEntity
import com.udacity.asteroid.radar.domain.model.PictureOfTheDayModel

object PictureOfTheDayMapper {

    fun transformEntityToModel(pictureOfTheDayEntity: PictureOfTheDayEntity): com.udacity.asteroid.radar.domain.model.PictureOfTheDayModel {
        return com.udacity.asteroid.radar.domain.model.PictureOfTheDayModel(
            pictureOfTheDayEntity.copyright,
            pictureOfTheDayEntity.date,
            pictureOfTheDayEntity.explanation,
            pictureOfTheDayEntity.title,
            pictureOfTheDayEntity.url,
            pictureOfTheDayEntity.mediaType
        )
    }

    fun transformModelToEntity(pictureOfTheDayModel: com.udacity.asteroid.radar.domain.model.PictureOfTheDayModel): PictureOfTheDayEntity {
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