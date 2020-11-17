package com.udacity.asteroid.radar.data.service

import com.udacity.asteroid.radar.data.datastore.PictureDataStore
import com.udacity.asteroid.radar.data.entity.PictureOfTheDayResponse
import com.udacity.asteroid.radar.data.mapper.ErrorMapper
import com.udacity.asteroid.radar.data.mapper.PictureOfTheDayMapper
import com.udacity.asteroid.radar.data.network.ApiManagerMoshi
import com.udacity.asteroid.radar.data.storage.database.AsteroidDao
import com.udacity.asteroid.radar.data.util.ErrorUtil
import com.udacity.asteroid.radar.data.util.RetrofitErrorUtil
import com.udacity.asteroid.radar.domain.model.ErrorModel
import com.udacity.asteroid.radar.domain.model.PictureOfTheDayModel
import com.udacity.asteroid.radar.domain.util.ResultType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PictureOfTheDayServiceDataStore(private val asteroidDao: AsteroidDao) :
    PictureDataStore {

    override suspend fun get(): ResultType<PictureOfTheDayModel, ErrorModel> {

        return try {
            val response = ApiManagerMoshi.get().pictureOfTheDay()
            if (response.isSuccessful) {
                val pictureOfTheDayResponse = response.body()!!
                savePicture(pictureOfTheDayResponse)
                ResultType.Success(
                    PictureOfTheDayMapper.transformResponseToModel(
                        pictureOfTheDayResponse
                    )
                )
            } else {
                val error = RetrofitErrorUtil.parseError(response)!!
                ResultType.Error(ErrorMapper.transformResponseToModel(error))
            }

        } catch (t: Throwable) {
            ResultType.Error(ErrorUtil.errorHandler(t))
        }
    }

    private suspend fun savePicture(pictureOfTheDayResponse: PictureOfTheDayResponse) =
        withContext(Dispatchers.IO) {
            asteroidDao.insertPicture(
                PictureOfTheDayMapper.transformResponseToEntity(pictureOfTheDayResponse)
            )
        }

}