package com.udacity.asteroid.radar.data.datastore

import android.content.Context
import com.udacity.asteroid.radar.data.service.AsteroidListServiceDataStore
import com.udacity.asteroid.radar.data.storage.AsteroidStorageDataStore
import com.udacity.asteroid.radar.data.storage.database.AsteroidDatabase
import com.udacity.asteroid.radar.data.util.isInternet

class AsteroidDataStoreFactory(private val context: Context) {

    fun create(): AsteroidDataStore {
        val asteroidDatabase = AsteroidDatabase.getDatabase(context)

        val value = if (context.isInternet()) Preference.CLOUD else Preference.DB

        return if (Preference.CLOUD == value) {
            AsteroidListServiceDataStore(asteroidDatabase)
        } else {
            AsteroidStorageDataStore(asteroidDatabase)
        }

    }

    enum class Preference {
        CLOUD, DB
    }

}