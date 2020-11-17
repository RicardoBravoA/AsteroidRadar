package com.udacity.asteroid.radar.data.datastore

import com.udacity.asteroid.radar.domain.model.ErrorModel
import com.udacity.asteroid.radar.domain.model.PictureOfTheDayModel
import com.udacity.asteroid.radar.domain.util.ResultType

interface PictureDataStore {

    suspend fun get(): ResultType<PictureOfTheDayModel, ErrorModel>
}