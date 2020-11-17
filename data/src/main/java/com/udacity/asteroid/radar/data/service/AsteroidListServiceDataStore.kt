package com.udacity.asteroid.radar.data.service

import com.udacity.asteroid.radar.data.datastore.AsteroidDataStore
import com.udacity.asteroid.radar.data.network.ApiManager
import com.udacity.asteroid.radar.domain.model.AsteroidModel
import com.udacity.asteroid.radar.domain.model.ErrorModel
import com.udacity.asteroid.radar.domain.util.ResultType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AsteroidListServiceDataStore : AsteroidDataStore {

    override suspend fun asteroidList(
        startDate: String,
        endDate: String
    ): ResultType<List<AsteroidModel>, ErrorModel> {

        withContext(Dispatchers.IO) {
            val list = ApiManager.get().feed(startDate, endDate)
            val asteroidList = NetworkUtils.parseStringToAsteroidList(list)

            asteroidList.forEach {
                database.asteroidDao.insertAsteroid(AsteroidMapper.transformAsteroidModelToEntity(it))
            }
        }

        return try {
            val response = ApiManager.apiManager().listCounter().await()

            return if (response.isSuccessful) {
                val counterResponse = response.body()
                ResultType.Success(CounterResponseMapper.transform(counterResponse!!))
            } else {
                val error = RetrofitErrorUtil.parseError(response)!!
                ResultType.Error(ErrorMapper.transform(error))
            }
        } catch (t: Throwable) {
            ResultType.Error(ErrorUtil.errorHandler(t))
        }
    }

}