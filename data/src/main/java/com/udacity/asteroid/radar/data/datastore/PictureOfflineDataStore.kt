package com.udacity.asteroid.radar.data.datastore

interface PictureOfflineDataStore : PictureDataStore {

    suspend fun delete()

}