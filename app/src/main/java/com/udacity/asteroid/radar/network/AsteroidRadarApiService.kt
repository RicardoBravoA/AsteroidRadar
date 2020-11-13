package com.udacity.asteroid.radar.network

import retrofit2.http.GET
import retrofit2.http.Query

interface AsteroidRadarApiService {

    @GET("v1/feed")
    suspend fun feed(
        @Query("start_date") startDate: String,
        @Query("end_date") endDate: String,
        @Query("api_key") apiKey: String = "oGWMd3Q0tO6xEMwTr38Kj74d84lJcQof2K1aD8sq"
    ): String

}