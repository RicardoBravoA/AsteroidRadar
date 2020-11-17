package com.udacity.asteroid.radar.data.mapper

import com.udacity.asteroid.radar.data.entity.AsteroidResponse
import com.udacity.asteroid.radar.data.storage.entity.AsteroidEntity
import com.udacity.asteroid.radar.domain.model.AsteroidModel

object AsteroidMapper {

    /*fun transformResponseToEntity(asteroidResponseList: List<AsteroidResponse>): List<AsteroidEntity> {
        val asteroidEntityList = mutableListOf<AsteroidEntity>()

        asteroidResponseList.forEach {
            asteroidEntityList.add(transformAsteroidResponseToEntity(it))
        }
        return asteroidEntityList
    }*/

    fun transformAsteroidResponseToEntity(asteroidResponse: AsteroidResponse): AsteroidEntity {
        return AsteroidEntity(
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

    fun transformEntityToModel(asteroidEntityList: List<AsteroidEntity>): List<AsteroidModel> {
        val asteroidModelList = mutableListOf<AsteroidModel>()

        asteroidEntityList.forEach {
            asteroidModelList.add(transformAsteroidEntityToModel(it))
        }
        return asteroidModelList
    }

    private fun transformAsteroidEntityToModel(asteroidEntity: AsteroidEntity): AsteroidModel {
        return AsteroidModel(
            asteroidEntity.id,
            asteroidEntity.codename,
            asteroidEntity.closeApproachDate,
            asteroidEntity.absoluteMagnitude,
            asteroidEntity.estimatedDiameter,
            asteroidEntity.relativeVelocity,
            asteroidEntity.distanceFromEarth,
            asteroidEntity.isPotentiallyHazardous
        )
    }

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