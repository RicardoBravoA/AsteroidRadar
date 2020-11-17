package com.udacity.asteroid.radar.data.service

import com.udacity.asteroid.radar.data.datastore.AsteroidDataStore
import com.udacity.asteroid.radar.data.entity.AsteroidResponse
import com.udacity.asteroid.radar.data.mapper.AsteroidMapper
import com.udacity.asteroid.radar.data.mapper.ErrorMapper
import com.udacity.asteroid.radar.data.network.ApiManager
import com.udacity.asteroid.radar.data.storage.database.AsteroidDatabase
import com.udacity.asteroid.radar.data.util.ErrorUtil
import com.udacity.asteroid.radar.data.util.NetworkUtils
import com.udacity.asteroid.radar.data.util.RetrofitErrorUtil
import com.udacity.asteroid.radar.domain.model.AsteroidModel
import com.udacity.asteroid.radar.domain.model.ErrorModel
import com.udacity.asteroid.radar.domain.util.ResultType

class AsteroidListServiceDataStore(private val asteroidDatabase: AsteroidDatabase) :
    AsteroidDataStore {

    override suspend fun asteroidList(
        startDate: String,
        endDate: String
    ): ResultType<List<AsteroidModel>, ErrorModel> {

        return try {
            val response = ApiManager.get().feed(startDate, endDate)
            if (response.isSuccessful) {
                val asteroidString = response.body()
                val asteroidList = NetworkUtils.parseStringToAsteroidList(asteroidString!!)
                saveAsteroid(asteroidList)
                ResultType.Success(AsteroidMapper.transformResponseToModel(asteroidList))
            } else {
                val error = RetrofitErrorUtil.parseError(response)!!
                ResultType.Error(ErrorMapper.transformResponseToModel(error))
            }

        } catch (t: Throwable) {
            ResultType.Error(ErrorUtil.errorHandler(t))
        }
    }

    private fun saveAsteroid(list: List<AsteroidResponse>) {
        list.forEach {
            asteroidDatabase.asteroidDao.insertAsteroid(
                AsteroidMapper.transformAsteroidResponseToEntity(
                    it
                )
            )
        }
    }

}