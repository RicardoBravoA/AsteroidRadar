package com.udacity.asteroid.radar.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.udacity.asteroid.radar.data.storage.AsteroidDatabase
import com.udacity.asteroid.radar.domain.model.AsteroidModel
import com.udacity.asteroid.radar.data.network.ApiManager
import com.udacity.asteroid.radar.data.util.NetworkUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AsteroidRepository(private val database: com.udacity.asteroid.radar.data.storage.AsteroidDatabase) {

    val asteroidList: LiveData<List<com.udacity.asteroid.radar.domain.model.AsteroidModel>> =
        Transformations.map(database.asteroidDao.getAsteroidsList()) {
            AsteroidMapper.transformEntityToModel(it)
        }

    suspend fun refreshAsteroids(startDate: String, endDate: String) {
        withContext(Dispatchers.IO) {
            val list = ApiManager.get().feed(startDate, endDate)
            val asteroidList = com.udacity.asteroid.radar.data.util.NetworkUtils.parseStringToAsteroidList(list)

            asteroidList.forEach {
                database.asteroidDao.insertAsteroid(AsteroidMapper.transformAsteroidModelToEntity(it))
            }
        }
    }
}