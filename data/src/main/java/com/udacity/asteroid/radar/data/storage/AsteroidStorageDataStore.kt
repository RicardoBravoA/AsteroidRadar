package com.udacity.asteroid.radar.data.storage

import com.udacity.asteroid.radar.data.datastore.AsteroidDataStore
import com.udacity.asteroid.radar.data.mapper.AsteroidMapper
import com.udacity.asteroid.radar.data.storage.database.AsteroidDao
import com.udacity.asteroid.radar.domain.model.AsteroidModel
import com.udacity.asteroid.radar.domain.model.ErrorModel
import com.udacity.asteroid.radar.domain.util.ResultType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AsteroidStorageDataStore(private val asteroidDao: AsteroidDao) : AsteroidDataStore {

    override suspend fun list(
        startDate: String,
        endDate: String
    ): ResultType<List<AsteroidModel>, ErrorModel> = withContext(Dispatchers.IO) {

        try {
            val response = asteroidDao.getAsteroidList(startDate, endDate)
            return@withContext ResultType.Success(AsteroidMapper.transformEntityToModel(response))
        } catch (t: Throwable) {
            return@withContext ResultType.Error(ErrorModel())
        }
    }
}