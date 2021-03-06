package com.udacity.asteroid.radar.data.datastore

import com.udacity.asteroid.radar.domain.model.ErrorModel
import com.udacity.asteroid.radar.domain.model.PictureModel
import com.udacity.asteroid.radar.domain.util.ResultType

interface PictureDataStore {

    suspend fun get(): ResultType<PictureModel, ErrorModel>
}