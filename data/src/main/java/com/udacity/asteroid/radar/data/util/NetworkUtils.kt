package com.udacity.asteroid.radar.data.util

import android.content.Context
import com.udacity.asteroid.radar.data.entity.AsteroidResponse
import com.udacity.asteroid.radar.domain.model.AsteroidModel
import com.udacity.asteroid.radar.domain.model.PictureModel
import org.json.JSONObject
import kotlin.collections.ArrayList

object NetworkUtils {

    fun parseImageOfTheDay(context: Context): PictureModel {
        val response = JsonUtils.loadJSONFromAsset(context, "image_of_day.json")
        var imageOfTheDay = PictureModel("", "", "", "", "")

        response?.let {
            val jsonObject = JSONObject(response)
            val date = jsonObject.getString("date")
            val explanation = jsonObject.getString("explanation")
            val title = jsonObject.getString("title")
            val url = jsonObject.getString("url")
            val mediaType = jsonObject.getString("media_type")

            imageOfTheDay = PictureModel(
                url,
                mediaType,
                title,
                date,
                explanation
            )
        }
        return imageOfTheDay
    }

    fun parseStringToAsteroidList(context: Context): List<AsteroidModel> {
        val response = JsonUtils.loadJSONFromAsset(context, "asteroids.json")
        val asteroidList = mutableListOf<AsteroidModel>()

        response?.let {
            val jsonObject = JSONObject(response)
            val nearEarthObjectsJson = jsonObject.getJSONObject("near_earth_objects")
            val nextSevenDaysFormattedDates = DataDateUtil.nextFormattedDates()

            for (formattedDate in nextSevenDaysFormattedDates) {
                val dateAsteroidJsonArray = nearEarthObjectsJson.getJSONArray(formattedDate)

                for (i in 0 until dateAsteroidJsonArray.length()) {
                    val asteroidJson = dateAsteroidJsonArray.getJSONObject(i)
                    val id = asteroidJson.getLong("id")
                    val codename = asteroidJson.getString("name")
                    val absoluteMagnitude = asteroidJson.getDouble("absolute_magnitude_h")
                    val estimatedDiameter = asteroidJson.getJSONObject("estimated_diameter")
                        .getJSONObject("kilometers").getDouble("estimated_diameter_max")

                    val closeApproachData = asteroidJson
                        .getJSONArray("close_approach_data").getJSONObject(0)
                    val relativeVelocity = closeApproachData.getJSONObject("relative_velocity")
                        .getDouble("kilometers_per_second")
                    val distanceFromEarth = closeApproachData.getJSONObject("miss_distance")
                        .getDouble("astronomical")
                    val isPotentiallyHazardous = asteroidJson
                        .getBoolean("is_potentially_hazardous_asteroid")

                    val asteroid = AsteroidModel(
                        id,
                        codename,
                        formattedDate,
                        absoluteMagnitude,
                        estimatedDiameter,
                        relativeVelocity,
                        distanceFromEarth,
                        isPotentiallyHazardous
                    )
                    asteroidList.add(asteroid)
                }
            }
        }

        return asteroidList
    }

    fun parseStringToAsteroidList(response: String): List<AsteroidResponse> {
        val asteroidList = mutableListOf<AsteroidResponse>()

        val jsonObject = JSONObject(response)
        val nearEarthObjectsJson = jsonObject.getJSONObject("near_earth_objects")
        val nextSevenDaysFormattedDates = DataDateUtil.nextFormattedDates()

        for (formattedDate in nextSevenDaysFormattedDates) {
            val dateAsteroidJsonArray = nearEarthObjectsJson.getJSONArray(formattedDate)

            for (i in 0 until dateAsteroidJsonArray.length()) {
                val asteroidJson = dateAsteroidJsonArray.getJSONObject(i)
                val id = asteroidJson.getLong("id")
                val codename = asteroidJson.getString("name")
                val absoluteMagnitude = asteroidJson.getDouble("absolute_magnitude_h")
                val estimatedDiameter = asteroidJson.getJSONObject("estimated_diameter")
                    .getJSONObject("kilometers").getDouble("estimated_diameter_max")

                val closeApproachData = asteroidJson
                    .getJSONArray("close_approach_data").getJSONObject(0)
                val relativeVelocity = closeApproachData.getJSONObject("relative_velocity")
                    .getDouble("kilometers_per_second")
                val distanceFromEarth = closeApproachData.getJSONObject("miss_distance")
                    .getDouble("astronomical")
                val isPotentiallyHazardous = asteroidJson
                    .getBoolean("is_potentially_hazardous_asteroid")

                val asteroid = AsteroidResponse(
                    id,
                    codename,
                    formattedDate,
                    absoluteMagnitude,
                    estimatedDiameter,
                    relativeVelocity,
                    distanceFromEarth,
                    isPotentiallyHazardous
                )
                asteroidList.add(asteroid)
            }
        }

        return asteroidList
    }

    fun parseAsteroidsJsonResult(jsonResult: JSONObject): ArrayList<AsteroidModel> {
        val nearEarthObjectsJson = jsonResult.getJSONObject("near_earth_objects")

        val asteroidList = ArrayList<AsteroidModel>()

        val nextSevenDaysFormattedDates = DataDateUtil.nextFormattedDates()
        for (formattedDate in nextSevenDaysFormattedDates) {
            val dateAsteroidJsonArray = nearEarthObjectsJson.getJSONArray(formattedDate)

            for (i in 0 until dateAsteroidJsonArray.length()) {
                val asteroidJson = dateAsteroidJsonArray.getJSONObject(i)
                val id = asteroidJson.getLong("id")
                val codename = asteroidJson.getString("name")
                val absoluteMagnitude = asteroidJson.getDouble("absolute_magnitude_h")
                val estimatedDiameter = asteroidJson.getJSONObject("estimated_diameter")
                    .getJSONObject("kilometers").getDouble("estimated_diameter_max")

                val closeApproachData = asteroidJson
                    .getJSONArray("close_approach_data").getJSONObject(0)
                val relativeVelocity = closeApproachData.getJSONObject("relative_velocity")
                    .getDouble("kilometers_per_second")
                val distanceFromEarth = closeApproachData.getJSONObject("miss_distance")
                    .getDouble("astronomical")
                val isPotentiallyHazardous = asteroidJson
                    .getBoolean("is_potentially_hazardous_asteroid")

                val asteroid = AsteroidModel(
                    id, codename, formattedDate, absoluteMagnitude,
                    estimatedDiameter, relativeVelocity, distanceFromEarth, isPotentiallyHazardous
                )
                asteroidList.add(asteroid)
            }
        }

        return asteroidList
    }

}