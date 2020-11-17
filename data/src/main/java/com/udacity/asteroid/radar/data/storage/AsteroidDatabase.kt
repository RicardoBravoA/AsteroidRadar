package com.udacity.asteroid.radar.data.storage

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.udacity.asteroid.radar.data.storage.entity.AsteroidEntity
import com.udacity.asteroid.radar.data.storage.entity.PictureOfTheDayEntity

@Database(entities = [AsteroidEntity::class, PictureOfTheDayEntity::class], version = 1)
abstract class AsteroidDatabase : RoomDatabase() {
    abstract val asteroidDao: com.udacity.asteroid.radar.data.storage.AsteroidDao

    companion object {
        @Volatile
        private lateinit var INSTANCE: AsteroidDatabase

        fun getDatabase(context: Context): AsteroidDatabase {
            synchronized(AsteroidDatabase::class.java) {
                if (!Companion::INSTANCE.isInitialized) {
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