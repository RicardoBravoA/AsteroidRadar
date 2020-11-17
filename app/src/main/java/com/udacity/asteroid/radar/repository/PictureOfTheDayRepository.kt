package com.udacity.asteroid.radar.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.udacity.asteroid.radar.database.AsteroidDatabase
import com.udacity.asteroid.radar.mapper.PictureOfTheDayMapper
import com.udacity.asteroid.radar.model.PictureOfTheDayModel
import com.udacity.asteroid.radar.network.ApiManagerMoshi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PictureOfTheDayRepository(private val database: AsteroidDatabase) {

    val pictureOfTheDay: LiveData<PictureOfTheDayModel> =
        Transformations.map(database.asteroidDao.getPicture()) {
            PictureOfTheDayMapper.transformEntityToModel(it)
        }

    suspend fun refreshPicture() {
        withContext(Dispatchers.IO) {
            val picture = ApiManagerMoshi.get().pictureOfTheDay()
            database.asteroidDao.insertPicture(PictureOfTheDayMapper.transformModelToEntity(picture))
        }
    }
}