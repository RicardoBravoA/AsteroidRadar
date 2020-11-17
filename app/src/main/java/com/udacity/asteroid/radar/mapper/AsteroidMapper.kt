package com.udacity.asteroid.radar.mapper

import com.udacity.asteroid.radar.data.storage.entity.AsteroidEntity
import com.udacity.asteroid.radar.domain.model.AsteroidModel

object AsteroidMapper {

    fun transformEntityToModel(asteroidEntityList: List<AsteroidEntity>): List<com.udacity.asteroid.radar.domain.model.AsteroidModel> {
        val asteroidModelList = mutableListOf<com.udacity.asteroid.radar.domain.model.AsteroidModel>()

        asteroidEntityList.forEach {
            asteroidModelList.add(transformAsteroidEntityToModel(it))
        }
        return asteroidModelList
    }

    private fun transformAsteroidEntityToModel(asteroidEntity: AsteroidEntity): com.udacity.asteroid.radar.domain.model.AsteroidModel {
        return com.udacity.asteroid.radar.domain.model.AsteroidModel(
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

    fun transformModelToEntity(asteroidModelList: List<com.udacity.asteroid.radar.domain.model.AsteroidModel>): List<AsteroidEntity> {
        val asteroidEntityList = mutableListOf<AsteroidEntity>()

        asteroidModelList.forEach {
            asteroidEntityList.add(transformAsteroidModelToEntity(it))
        }
        return asteroidEntityList
    }

    fun transformAsteroidModelToEntity(asteroidModel: com.udacity.asteroid.radar.domain.model.AsteroidModel): AsteroidEntity {
        return AsteroidEntity(
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