package com.udacity.asteroid.radar.mapper

import android.content.Context
import com.udacity.asteroid.radar.R
import com.udacity.asteroid.radar.detail.DetailModel
import com.udacity.asteroid.radar.model.AsteroidModel
import com.udacity.asteroid.radar.model.DetailItem

object DetailMapper {

    fun transform(context: Context, asteroidModel: AsteroidModel): List<DetailModel> {
        val list = mutableListOf<DetailModel>()
        list.add(DetailModel.Picture(asteroidModel.isPotentiallyHazardous))

        val detailList = transformItem(context, asteroidModel)

        detailList.forEach {
            list.add(DetailModel.Item(it))
        }

        return list
    }

    private fun transformItem(context: Context, asteroidModel: AsteroidModel): List<DetailItem> {
        val detailList = mutableListOf<DetailItem>()

        val closeApproach =
            DetailItem(
                context.getString(R.string.close_approach_data_title),
                asteroidModel.closeApproachDate
            )

        val absoluteMagnitude =
            DetailItem(
                context.getString(R.string.absolute_magnitude_title),
                String.format(
                    context.getString(R.string.astronomical_unit_format),
                    asteroidModel.absoluteMagnitude
                ), true
            )

        val estimatedDiameter =
            DetailItem(
                context.getString(R.string.estimated_diameter_title),
                String.format(
                    context.getString(R.string.km_unit_format),
                    asteroidModel.estimatedDiameter
                )
            )

        val relativeVelocity =
            DetailItem(
                context.getString(R.string.relative_velocity_title),
                String.format(
                    context.getString(R.string.km_s_unit_format),
                    asteroidModel.relativeVelocity
                )
            )

        val distanceFromEarth =
            DetailItem(
                context.getString(R.string.distance_from_earth_title),
                String.format(
                    context.getString(R.string.astronomical_unit_format),
                    asteroidModel.distanceFromEarth
                )
            )

        detailList.add(closeApproach)
        detailList.add(absoluteMagnitude)
        detailList.add(estimatedDiameter)
        detailList.add(relativeVelocity)
        detailList.add(distanceFromEarth)

        return detailList
    }

}