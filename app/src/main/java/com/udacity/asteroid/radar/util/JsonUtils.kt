package com.udacity.asteroid.radar.util

import android.content.Context
import java.io.IOException
import java.io.InputStream

object JsonUtils {

    fun loadJSONFromAsset(context: Context): String? {
        val json: String?
        json = try {
            val inputStream: InputStream = context.assets.open("asteroids.json")
            val size: Int = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            String(buffer, charset("UTF-8"))
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        return json
    }

}