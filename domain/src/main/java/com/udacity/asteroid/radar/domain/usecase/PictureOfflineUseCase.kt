package com.udacity.asteroid.radar.domain.usecase

import com.udacity.asteroid.radar.domain.model.ErrorModel
import com.udacity.asteroid.radar.domain.model.PictureModel
import com.udacity.asteroid.radar.domain.repository.PictureOfflineRepository
import com.udacity.asteroid.radar.domain.util.ResultType

class PictureOfflineUseCase(private val pictureRepository: PictureOfflineRepository) {

    suspend fun get(): ResultType<PictureModel, ErrorModel> {
        return pictureRepository.get()
    }

}