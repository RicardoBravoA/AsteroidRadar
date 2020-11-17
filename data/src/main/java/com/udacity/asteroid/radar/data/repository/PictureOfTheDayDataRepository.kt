package com.udacity.asteroid.radar.data.repository

import com.udacity.asteroid.radar.data.datastore.PictureOfTheDayDataStoreFactory
import com.udacity.asteroid.radar.domain.model.ErrorModel
import com.udacity.asteroid.radar.domain.model.PictureOfTheDayModel
import com.udacity.asteroid.radar.domain.repository.PictureOfTheDayRepository
import com.udacity.asteroid.radar.domain.util.ResultType

class PictureOfTheDayDataRepository(private val pictureOfTheDayDataStoreFactory: PictureOfTheDayDataStoreFactory) :
    PictureOfTheDayRepository {

    override suspend fun get(): ResultType<PictureOfTheDayModel, ErrorModel> {
        val pictureDataStore = pictureOfTheDayDataStoreFactory.create()
        return pictureDataStore.get()
    }

}