package com.udacity.asteroid.radar.data.repository

import android.content.Context
import com.udacity.asteroid.radar.data.storage.AsteroidStorageDataStore
import com.udacity.asteroid.radar.data.storage.database.AsteroidDatabase
import com.udacity.asteroid.radar.domain.model.AsteroidModel
import com.udacity.asteroid.radar.domain.model.ErrorModel
import com.udacity.asteroid.radar.domain.repository.AsteroidOfflineRepository
import com.udacity.asteroid.radar.domain.util.ResultType

class AsteroidOfflineDataRepository(private val context: Context) :
    AsteroidOfflineRepository {

    override suspend fun list(
        startDate: String,
        endDate: String
    ): ResultType<List<AsteroidModel>, ErrorModel> {
        val asteroidDatabase = AsteroidDatabase.getDatabase(context)
        return AsteroidStorageDataStore(asteroidDatabase.asteroidDao).list(startDate, endDate)
    }

}