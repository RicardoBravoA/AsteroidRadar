package com.udacity.asteroid.radar.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.udacity.asteroid.radar.database.entity.AsteroidEntity
import com.udacity.asteroid.radar.database.entity.PictureOfTheDayEntity

@Database(entities = [AsteroidEntity::class, PictureOfTheDayEntity::class], version = 1)
abstract class AsteroidDatabase : RoomDatabase() {
    abstract val asteroidDao: AsteroidDao

    companion object {
        @Volatile
        private lateinit var INSTANCE: AsteroidDatabase

        fun getDatabase(context: Context): AsteroidDatabase {
            synchronized(AsteroidDatabase::class.java) {
                if (!::INSTANCE.isInitialized) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AsteroidDatabase::class.java,
                        "asteroid"
                    ).build()
                }
            }
            return INSTANCE
        }
    }

}