package com.udacity.asteroid.radar.data.datastore

import com.udacity.asteroid.radar.domain.model.AsteroidModel
import com.udacity.asteroid.radar.domain.model.ErrorModel
import com.udacity.asteroid.radar.domain.util.ResultType

interface AsteroidDataStore {

    suspend fun asteroidList(): ResultType<List<AsteroidModel>, ErrorModel>
}