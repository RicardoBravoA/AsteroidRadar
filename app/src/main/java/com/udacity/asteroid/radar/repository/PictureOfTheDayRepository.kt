package com.udacity.asteroid.radar.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.udacity.asteroid.radar.database.AsteroidDatabase
import com.udacity.asteroid.radar.mapper.AsteroidMapper
import com.udacity.asteroid.radar.model.AsteroidModel
import com.udacity.asteroid.radar.model.PictureOfTheDayModel
import com.udacity.asteroid.radar.network.ApiManager
import com.udacity.asteroid.radar.util.NetworkUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PictureOfTheDayRepository(private val database: AsteroidDatabase) {

    val pictureOfTheDay: LiveData<PictureOfTheDayModel> =
        Transformations.map(database.asteroidDao.getPicture()) {
            AsteroidMapper.transformEntityToModel(it)
        }

    suspend fun refreshAsteroids(startDate: String, endDate: String) {
        withContext(Dispatchers.IO) {
            val list = ApiManager.get().feed(startDate, endDate)
            val asteroidList = NetworkUtils.parseStringToAsteroidList(list)

            asteroidList.forEach {
                database.asteroidDao.insertAsteroid(AsteroidMapper.transformAsteroidModelToEntity(it))
            }
        }
    }
}