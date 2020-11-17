package com.udacity.asteroid.radar.data.datastore

import android.content.Context
import com.udacity.asteroid.radar.data.service.PictureServiceDataStore
import com.udacity.asteroid.radar.data.storage.database.AsteroidDatabase
import com.udacity.asteroid.radar.data.util.isInternet

class PictureDataStoreFactory(private val context: Context) {

    fun create(): PictureDataStore {
        val asteroidDatabase = AsteroidDatabase.getDatabase(context)
        val value = if (context.isInternet()) Preference.CLOUD else Preference.DB

        return if (Preference.CLOUD == value) {
            PictureServiceDataStore(asteroidDatabase.asteroidDao)
        } else {
            PictureServiceDataStore(asteroidDatabase.asteroidDao)
        }
    }

    enum class Preference {
        CLOUD, DB
    }

}