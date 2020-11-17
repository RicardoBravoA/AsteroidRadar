package com.udacity.asteroid.radar.data.repository

import com.udacity.asteroid.radar.data.service.AsteroidListServiceDataStore
import com.udacity.asteroid.radar.domain.model.AsteroidModel
import com.udacity.asteroid.radar.domain.model.ErrorModel
import com.udacity.asteroid.radar.domain.repository.AsteroidListRepository
import com.udacity.asteroid.radar.domain.util.ResultType

class AsteroidListDataRepository : AsteroidListRepository {

    override suspend fun asteroidList(
        startDate: String,
        endDate: String
    ): ResultType<List<AsteroidModel>, ErrorModel> {
        val serviceDataStore = AsteroidListServiceDataStore()
        return serviceDataStore.asteroidList(startDate, endDate)
    }

}