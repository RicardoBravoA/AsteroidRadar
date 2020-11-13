package com.udacity.asteroid.radar.network

import com.udacity.asteroid.radar.model.PictureOfTheDay
import com.udacity.asteroid.radar.util.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("neo/rest/v1/feed")
    suspend fun feed(
        @Query("start_date") startDate: String,
        @Query("end_date") endDate: String,
        @Query("api_key") apiKey: String = Constants.KEY
    ): String

    @GET("planetary/apod")
    suspend fun imageOfTheDay(
        @Query("api_key") apiKey: String = Constants.KEY
    ): PictureOfTheDay

}