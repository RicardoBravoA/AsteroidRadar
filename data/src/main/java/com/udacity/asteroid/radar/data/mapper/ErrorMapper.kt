package com.udacity.asteroid.radar.data.mapper

import com.udacity.asteroid.radar.data.entity.ErrorResponse
import com.udacity.asteroid.radar.domain.model.ErrorModel

object ErrorMapper {

    fun transformResponseToModel(errorResponse: ErrorResponse): ErrorModel {
        return ErrorModel(
            errorResponse.message
        )
    }

    fun transformModelToResponse(errorModel: ErrorModel): ErrorResponse {
        return ErrorResponse(
            errorModel.message
        )
    }

}