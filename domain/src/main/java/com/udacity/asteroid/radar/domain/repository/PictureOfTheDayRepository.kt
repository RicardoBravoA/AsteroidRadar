package com.udacity.asteroid.radar.domain.repository

import com.udacity.asteroid.radar.domain.model.ErrorModel
import com.udacity.asteroid.radar.domain.model.PictureOfTheDayModel
import com.udacity.asteroid.radar.domain.util.ResultType

interface PictureOfTheDayRepository {

    suspend fun picture(): ResultType<PictureOfTheDayModel, ErrorModel>
}