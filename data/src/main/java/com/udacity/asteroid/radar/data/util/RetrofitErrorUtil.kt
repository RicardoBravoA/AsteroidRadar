package com.udacity.asteroid.radar.data.util

import com.udacity.asteroid.radar.data.entity.ErrorResponse
import com.udacity.asteroid.radar.data.network.ApiManager
import retrofit2.Response
import java.io.IOException

object RetrofitErrorUtil {
    fun parseError(response: Response<*>): ErrorResponse? {

        val converter = ApiManager.retrofit.responseBodyConverter<ErrorResponse>(
            ErrorResponse::class.java,
            arrayOfNulls<Annotation>(0)
        )

        val error: ErrorResponse

        try {
            error = converter.convert(response.errorBody()!!)!!
        } catch (e: IOException) {
            return ErrorResponse()
        }

        return error
    }
}