package com.udacity.asteroid.radar.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.udacity.asteroid.radar.database.AsteroidDatabase
import com.udacity.asteroid.radar.model.AsteroidModel
import com.udacity.asteroid.radar.network.ApiManager
import com.udacity.asteroid.radar.network.ApiManagerMoshi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AsteroidRepository(private val database: AsteroidDatabase) {

    val asteroidList: LiveData<List<AsteroidModel>> =
        Transformations.map(database.asteroidDao.getAsteroidsList()) {
            it.asDomainModel()
        }

    suspend fun refreshVideos(startDate: String, endDate: String) {
        withContext(Dispatchers.IO) {
            val list = ApiManager.get().feed(startDate, endDate)
            database.asteroidDao.insertAll(list)
//            database.videoDao.insertAll(*playlist.asDatabaseModel())
        }
    }
}