package com.udacity.asteroid.radar.mapper

import com.udacity.asteroid.radar.database.entity.AsteroidEntity
import com.udacity.asteroid.radar.model.AsteroidModel

object AsteroidMapper {

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

    fun transformModelToEntity(asteroidModelList: List<AsteroidModel>): List<AsteroidEntity> {
        val asteroidEntityList = mutableListOf<AsteroidEntity>()

        asteroidModelList.forEach {
            asteroidEntityList.add(transformAsteroidModelToEntity(it))
        }
        return asteroidEntityList
    }

    fun transformAsteroidModelToEntity(asteroidModel: AsteroidModel): AsteroidEntity {
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