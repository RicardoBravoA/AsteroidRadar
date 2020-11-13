package com.udacity.asteroid.radar.mapper

import android.content.Context
import com.udacity.asteroid.radar.R
import com.udacity.asteroid.radar.model.Asteroid
import com.udacity.asteroid.radar.model.DetailItem

object DetailMapper {

    fun transform(context: Context, asteroid: Asteroid): List<DetailItem> {
        val detailList = mutableListOf<DetailItem>()

        val closeApproach =
            DetailItem(
                context.getString(R.string.close_approach_data_title),
                asteroid.closeApproachDate
            )

        val absoluteMagnitude =
            DetailItem(
                context.getString(R.string.absolute_magnitude_title),
                String.format(
                    context.getString(R.string.astronomical_unit_format),
                    asteroid.absoluteMagnitude, true
                )
            )

        val estimatedDiameter =
            DetailItem(
                context.getString(R.string.estimated_diameter_title),
                String.format(
                    context.getString(R.string.km_unit_format),
                    asteroid.estimatedDiameter
                )
            )

        val relativeVelocity =
            DetailItem(
                context.getString(R.string.relative_velocity_title),
                String.format(
                    context.getString(R.string.km_s_unit_format),
                    asteroid.relativeVelocity
                )
            )

        val distanceFromEarth =
            DetailItem(
                context.getString(R.string.distance_from_earth_title),
                String.format(
                    context.getString(R.string.astronomical_unit_format),
                    asteroid.distanceFromEarth
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