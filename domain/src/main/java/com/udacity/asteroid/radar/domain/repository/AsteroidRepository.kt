package com.udacity.asteroid.radar.domain.repository

import com.udacity.asteroid.radar.domain.model.AsteroidModel
import com.udacity.asteroid.radar.domain.model.ErrorModel
import com.udacity.asteroid.radar.domain.util.ResultType

interface AsteroidRepository {

    suspend fun list(
        startDate: String,
        endDate: String
    ): ResultType<List<AsteroidModel>, ErrorModel>
}