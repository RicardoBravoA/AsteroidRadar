package com.udacity.asteroid.radar.data.storage

import com.udacity.asteroid.radar.data.datastore.PictureDataStore
import com.udacity.asteroid.radar.data.mapper.PictureMapper
import com.udacity.asteroid.radar.data.storage.database.AsteroidDao
import com.udacity.asteroid.radar.domain.model.ErrorModel
import com.udacity.asteroid.radar.domain.model.PictureModel
import com.udacity.asteroid.radar.domain.util.ResultType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PictureStorageDataStore(private val asteroidDao: AsteroidDao) : PictureDataStore {

    override suspend fun get(): ResultType<PictureModel, ErrorModel> = withContext(Dispatchers.IO) {

        try {
            val response = asteroidDao.getPicture()
            return@withContext ResultType.Success(PictureMapper.transformEntityToModel(response))
        } catch (t: Throwable) {
            return@withContext ResultType.Error(ErrorModel())
        }
    }
}