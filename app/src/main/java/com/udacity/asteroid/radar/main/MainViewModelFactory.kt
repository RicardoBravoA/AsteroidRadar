package com.udacity.asteroid.radar.main

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.udacity.asteroid.radar.data.datastore.AsteroidDataStoreFactory
import com.udacity.asteroid.radar.data.repository.AsteroidDataRepository
import com.udacity.asteroid.radar.domain.usecase.AsteroidUseCase

@Suppress("UNCHECKED_CAST")
class MainViewModelFactory(val app: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            val asteroidDataRepository = AsteroidDataRepository(AsteroidDataStoreFactory(app))
            val asteroidUseCase = AsteroidUseCase(asteroidDataRepository)
            return MainViewModel(app) as T
        }
        throw IllegalArgumentException("Unable to construct viewmodel")
    }
}