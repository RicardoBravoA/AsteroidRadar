package com.udacity.asteroid.radar.data.util

import java.text.SimpleDateFormat
import java.util.*

object DataDateUtil {

    private const val API_QUERY_DATE_FORMAT = "yyyy-MM-dd"
    const val DEFAULT_END_DATE_DAYS = 7

    fun currentDate(nextDay: Int = 0): String {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_YEAR, nextDay)
        val currentTime = calendar.time
        val dateFormat = SimpleDateFormat(API_QUERY_DATE_FORMAT, Locale.getDefault())
        return dateFormat.format(currentTime)
    }

    fun nextFormattedDates(nextDays: Int = DEFAULT_END_DATE_DAYS): ArrayList<String> {
        val formattedDateList = ArrayList<String>()
        for (i in 0..nextDays) {
            formattedDateList.add(currentDate(i))
        }

        return formattedDateList
    }

}

