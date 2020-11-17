package com.udacity.asteroid.radar.data.mapper

import com.udacity.asteroid.radar.data.entity.AsteroidResponse
import com.udacity.asteroid.radar.domain.model.AsteroidModel

object AsteroidMapper {

    fun transformResponseToModel(asteroidResponseList: List<AsteroidResponse>): List<AsteroidModel> {
        val asteroidModelList = mutableListOf<AsteroidModel>()

        asteroidResponseList.forEach {
            asteroidModelList.add(transformAsteroidResponseToModel(it))
        }
        return asteroidModelList
    }

    private fun transformAsteroidResponseToModel(asteroidResponse: AsteroidResponse): AsteroidModel {
        return AsteroidModel(
            asteroidResponse.id,
            asteroidResponse.codename,
            asteroidResponse.closeApproachDate,
            asteroidResponse.absoluteMagnitude,
            asteroidResponse.estimatedDiameter,
            asteroidResponse.relativeVelocity,
            asteroidResponse.distanceFromEarth,
            asteroidResponse.isPotentiallyHazardous
        )
    }

    fun transformModelToResponse(asteroidModelList: List<AsteroidModel>): List<AsteroidResponse> {
        val asteroidResponseList = mutableListOf<AsteroidResponse>()

        asteroidModelList.forEach {
            asteroidResponseList.add(transformAsteroidModelToResponse(it))
        }
        return asteroidResponseList
    }

    fun transformAsteroidModelToResponse(asteroidModel: AsteroidModel): AsteroidResponse {
        return AsteroidResponse(
            asteroidModel.id,
            asteroidModel.codename,
            asteroidModel.closeApproachDate,
            asteroidModel.absoluteMagnitude,
            asteroidModel.estimatedDiameter,
            asteroidModel.relativeVelocity,
            asteroidModel.distanceFromEarth,
            asteroidModel.isPotentiallyHazardous
        )
    }

}