package com.udacity.asteroid.radar.data.storage

import com.udacity.asteroid.radar.data.datastore.AsteroidDataStore
import com.udacity.asteroid.radar.data.mapper.AsteroidMapper
import com.udacity.asteroid.radar.data.storage.database.AsteroidDatabase
import com.udacity.asteroid.radar.domain.model.AsteroidModel
import com.udacity.asteroid.radar.domain.model.ErrorModel
import com.udacity.asteroid.radar.domain.util.ResultType

class AsteroidStorageDataStore(private val asteroidDatabase: AsteroidDatabase) : AsteroidDataStore {

    override suspend fun list(
        startDate: String,
        endDate: String
    ): ResultType<List<AsteroidModel>, ErrorModel> {
        val response = asteroidDatabase.asteroidDao.getAsteroidList()

        response.value?.let {
            return ResultType.Success(AsteroidMapper.transformEntityToModel(it))
        } ?: return ResultType.Error(ErrorModel())
    }

}