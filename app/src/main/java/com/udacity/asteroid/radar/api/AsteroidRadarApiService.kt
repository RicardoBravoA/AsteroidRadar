package com.udacity.asteroid.radar.api

import retrofit2.http.GET
import retrofit2.http.Query

interface AsteroidRadarApiService {

    @GET("feed")
    suspend fun feed(
        @Query("start_date") startDate: String,
        @Query("end_date") endDate: String
    ): String

}