package com.udacity.asteroid.radar.domain.usecase

import com.udacity.asteroid.radar.domain.model.AsteroidModel
import com.udacity.asteroid.radar.domain.model.ErrorModel
import com.udacity.asteroid.radar.domain.repository.AsteroidRepository
import com.udacity.asteroid.radar.domain.util.ResultType

class AsteroidUseCase(private val asteroidRepository: AsteroidRepository) {

    suspend fun list(
        startDate: String,
        endDate: String
    ): ResultType<List<AsteroidModel>, ErrorModel> {
        return asteroidRepository.list(startDate, endDate)
    }
}