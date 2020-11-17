package com.udacity.asteroid.radar.data.repository

import com.udacity.asteroid.radar.data.service.AsteroidServiceDataStore
import com.udacity.asteroid.radar.data.storage.database.AsteroidDatabase
import com.udacity.asteroid.radar.domain.model.AsteroidModel
import com.udacity.asteroid.radar.domain.model.ErrorModel
import com.udacity.asteroid.radar.domain.repository.AsteroidRepository
import com.udacity.asteroid.radar.domain.util.ResultType

class AsteroidDataRepository(private val asteroidDatabase: AsteroidDatabase) : AsteroidRepository {

    override suspend fun list(
        startDate: String,
        endDate: String
    ): ResultType<List<AsteroidModel>, ErrorModel> {
        val serviceDataStore = AsteroidServiceDataStore(asteroidDatabase)
        return serviceDataStore.list(startDate, endDate)
    }

}