package com.udacity.asteroid.radar.domain.repository

import com.udacity.asteroid.radar.domain.model.AsteroidModel
import com.udacity.asteroid.radar.domain.model.ErrorModel
import com.udacity.asteroid.radar.domain.util.ResultType

interface AsteroidListRepository {

    suspend fun asteroidList(): ResultType<List<AsteroidModel>, ErrorModel>
}