package com.udacity.asteroid.radar.data.workManager

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.udacity.asteroid.radar.data.datastore.AsteroidDataStoreFactory
import com.udacity.asteroid.radar.data.datastore.PictureDataStoreFactory
import com.udacity.asteroid.radar.data.repository.AsteroidDataRepository
import com.udacity.asteroid.radar.data.repository.AsteroidOfflineDataRepository
import com.udacity.asteroid.radar.data.repository.PictureDataRepository
import com.udacity.asteroid.radar.data.repository.PictureOfflineDataRepository
import com.udacity.asteroid.radar.data.util.DataDateUtil
import com.udacity.asteroid.radar.domain.usecase.AsteroidOfflineUseCase
import com.udacity.asteroid.radar.domain.usecase.AsteroidUseCase
import com.udacity.asteroid.radar.domain.usecase.PictureOfflineUseCase
import com.udacity.asteroid.radar.domain.usecase.PictureUseCase
import retrofit2.HttpException

class RefreshDataWorker(context: Context, params: WorkerParameters) :
    CoroutineWorker(context, params) {

    companion object {
        const val WORK_NAME = "RefreshDataWorker"
    }

    override suspend fun doWork(): Result {
        val asteroidDataRepository =
            AsteroidDataRepository(AsteroidDataStoreFactory(applicationContext))
        val asteroidUseCase = AsteroidUseCase(asteroidDataRepository)

        val asteroidOfflineDataRepository = AsteroidOfflineDataRepository(applicationContext)
        val asteroidOfflineUseCase = AsteroidOfflineUseCase(asteroidOfflineDataRepository)

        val pictureDataRepository =
            PictureDataRepository(PictureDataStoreFactory(applicationContext))
        val pictureUseCase = PictureUseCase(pictureDataRepository)

        val pictureOfflineDataRepository = PictureOfflineDataRepository(applicationContext)
        val pictureOfflineUseCase = PictureOfflineUseCase(pictureOfflineDataRepository)

        return try {
            asteroidOfflineUseCase.delete(DataDateUtil.currentDate())
            pictureOfflineUseCase.delete()
            asteroidUseCase.list(
                DataDateUtil.currentDate(),
                DataDateUtil.currentDate(DataDateUtil.DEFAULT_END_DATE_DAYS)
            )
            pictureUseCase.get()
            Result.success()
        } catch (e: HttpException) {
            Result.retry()
        }
    }
}