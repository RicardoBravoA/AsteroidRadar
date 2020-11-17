package com.udacity.asteroid.radar.data.repository

import com.udacity.asteroid.radar.domain.model.AsteroidModel
import com.udacity.asteroid.radar.domain.model.ErrorModel
import com.udacity.asteroid.radar.domain.repository.AsteroidListRepository
import com.udacity.asteroid.radar.domain.util.ResultType

class AsteroidListDataRepository : AsteroidListRepository {

    override suspend fun asteroidList(): ResultType<List<AsteroidModel>, ErrorModel> {
        val listCounterServiceDataStore = ListCounterServiceDataStore()
        return listCounterServiceDataStore.listCounter()
    }

}