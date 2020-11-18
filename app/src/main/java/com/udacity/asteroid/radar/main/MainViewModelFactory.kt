package com.udacity.asteroid.radar.main

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.udacity.asteroid.radar.data.datastore.AsteroidDataStoreFactory
import com.udacity.asteroid.radar.data.datastore.PictureDataStoreFactory
import com.udacity.asteroid.radar.data.repository.AsteroidDataRepository
import com.udacity.asteroid.radar.data.repository.PictureDataRepository
import com.udacity.asteroid.radar.domain.usecase.AsteroidUseCase
import com.udacity.asteroid.radar.domain.usecase.PictureUseCase

@Suppress("UNCHECKED_CAST")
class MainViewModelFactory(val app: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            val asteroidDataRepository = AsteroidDataRepository(AsteroidDataStoreFactory(app))
            val asteroidUseCase = AsteroidUseCase(asteroidDataRepository)

            val pictureDataRepository = PictureDataRepository(PictureDataStoreFactory(app))
            val pictureUseCase = PictureUseCase(pictureDataRepository)
            return MainViewModel(asteroidUseCase, pictureUseCase) as T
        }
        throw IllegalArgumentException("Unable to construct view model")
    }
}