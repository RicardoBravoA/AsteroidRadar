package com.udacity.asteroid.radar.data.network

import com.udacity.asteroid.radar.data.entity.PictureOfTheDayResponse
import com.udacity.asteroid.radar.data.util.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("neo/rest/v1/feed")
    suspend fun feed(
        @Query("start_date") startDate: String,
        @Query("end_date") endDate: String,
        @Query("api_key") apiKey: String = Constants.KEY
    ): Response<String>

    @GET("planetary/apod")
    suspend fun pictureOfTheDay(
        @Query("api_key") apiKey: String = Constants.KEY
    ): Response<PictureOfTheDayResponse>

}