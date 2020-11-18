package com.udacity.asteroid.radar.domain.repository

import com.udacity.asteroid.radar.domain.model.ErrorModel
import com.udacity.asteroid.radar.domain.model.PictureModel
import com.udacity.asteroid.radar.domain.util.ResultType

interface PictureRepository {

    suspend fun get(): ResultType<PictureModel, ErrorModel>
}