package com.udacity.asteroid.radar.data.service

import com.udacity.asteroid.radar.data.datastore.AsteroidDataStore
import com.udacity.asteroid.radar.data.entity.AsteroidResponse
import com.udacity.asteroid.radar.data.mapper.AsteroidMapper
import com.udacity.asteroid.radar.data.mapper.ErrorMapper
import com.udacity.asteroid.radar.data.network.ApiManager
import com.udacity.asteroid.radar.data.storage.database.AsteroidDao
import com.udacity.asteroid.radar.data.util.NetworkUtils
import com.udacity.asteroid.radar.data.util.RetrofitErrorUtil
import com.udacity.asteroid.radar.domain.model.AsteroidModel
import com.udacity.asteroid.radar.domain.model.ErrorModel
import com.udacity.asteroid.radar.domain.util.ResultType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AsteroidServiceDataStore(private val asteroidDao: AsteroidDao) :
    AsteroidDataStore {

    override suspend fun list(
        startDate: String,
        endDate: String
    ): ResultType<List<AsteroidModel>, ErrorModel> {

        val response = ApiManager.get().feed(startDate, endDate)
        return if (response.isSuccessful) {
            val asteroidString = response.body()
            val asteroidList = NetworkUtils.parseStringToAsteroidList(asteroidString!!)
            saveAsteroid(asteroidList)
            ResultType.Success(AsteroidMapper.transformResponseToModel(asteroidList))
        } else {
            val error = RetrofitErrorUtil.parseError(response)!!
            ResultType.Error(ErrorMapper.transformResponseToModel(error))
        }
    }

    private suspend fun saveAsteroid(list: List<AsteroidResponse>) = withContext(Dispatchers.IO) {
        list.forEach {
            asteroidDao.insertAsteroid(
                AsteroidMapper.transformAsteroidResponseToEntity(
                    it
                )
            )
        }
    }

}