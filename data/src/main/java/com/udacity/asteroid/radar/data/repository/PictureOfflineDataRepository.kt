package com.udacity.asteroid.radar.data.repository

import android.content.Context
import com.udacity.asteroid.radar.data.storage.PictureStorageDataStore
import com.udacity.asteroid.radar.data.storage.database.AsteroidDatabase
import com.udacity.asteroid.radar.domain.model.ErrorModel
import com.udacity.asteroid.radar.domain.model.PictureModel
import com.udacity.asteroid.radar.domain.repository.PictureRepository
import com.udacity.asteroid.radar.domain.util.ResultType

class PictureOfflineDataRepository(private val context: Context) :
    PictureRepository {

    override suspend fun get(): ResultType<PictureModel, ErrorModel> {
        val asteroidDatabase = AsteroidDatabase.getDatabase(context)
        return PictureStorageDataStore(asteroidDatabase.asteroidDao).get()
    }

}