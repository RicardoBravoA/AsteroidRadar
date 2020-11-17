package com.udacity.asteroid.radar.data.repository

import com.udacity.asteroid.radar.data.datastore.AsteroidDataStoreFactory
import com.udacity.asteroid.radar.domain.model.AsteroidModel
import com.udacity.asteroid.radar.domain.model.ErrorModel
import com.udacity.asteroid.radar.domain.repository.AsteroidRepository
import com.udacity.asteroid.radar.domain.util.ResultType

class AsteroidDataRepository(private val asteroidDataStoreFactory: AsteroidDataStoreFactory) :
    AsteroidRepository {

    override suspend fun list(
        startDate: String,
        endDate: String
    ): ResultType<List<AsteroidModel>, ErrorModel> {
        val serviceDataStore = asteroidDataStoreFactory.create()
        return serviceDataStore.list(startDate, endDate)
    }

}