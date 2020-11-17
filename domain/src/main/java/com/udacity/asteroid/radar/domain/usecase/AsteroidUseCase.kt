package com.udacity.asteroid.radar.domain.usecase

import com.udacity.asteroid.radar.domain.model.AsteroidModel
import com.udacity.asteroid.radar.domain.model.ErrorModel
import com.udacity.asteroid.radar.domain.repository.AsteroidListRepository
import com.udacity.asteroid.radar.domain.util.ResultType

class AsteroidUseCase(private val asteroidListRepository: AsteroidListRepository) {

    suspend fun asteroidList(
        startDate: String,
        endDate: String
    ): ResultType<List<AsteroidModel>, ErrorModel> {
        return asteroidListRepository.asteroidList(startDate, endDate)
    }
}