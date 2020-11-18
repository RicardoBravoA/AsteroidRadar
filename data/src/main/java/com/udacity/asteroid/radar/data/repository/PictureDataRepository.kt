package com.udacity.asteroid.radar.data.repository

import com.udacity.asteroid.radar.data.datastore.PictureDataStoreFactory
import com.udacity.asteroid.radar.domain.model.ErrorModel
import com.udacity.asteroid.radar.domain.model.PictureModel
import com.udacity.asteroid.radar.domain.repository.PictureRepository
import com.udacity.asteroid.radar.domain.util.ResultType

class PictureDataRepository(private val pictureDataStoreFactory: PictureDataStoreFactory) :
    PictureRepository {

    override suspend fun get(): ResultType<PictureModel, ErrorModel> {
        val pictureDataStore = pictureDataStoreFactory.create()
        return pictureDataStore.get()
    }
}