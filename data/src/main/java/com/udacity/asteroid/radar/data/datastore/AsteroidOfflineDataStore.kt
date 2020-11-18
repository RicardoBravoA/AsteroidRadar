package com.udacity.asteroid.radar.data.datastore

interface AsteroidOfflineDataStore : AsteroidDataStore {

    suspend fun delete(currentDate: String)

}