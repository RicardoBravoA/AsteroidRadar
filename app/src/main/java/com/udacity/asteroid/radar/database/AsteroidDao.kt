package com.udacity.asteroid.radar.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.udacity.asteroid.radar.database.entity.AsteroidEntity
import com.udacity.asteroid.radar.database.entity.PictureOfTheDayEntity

@Dao
interface AsteroidDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg asteroids: AsteroidEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAsteroid(asteroid: AsteroidEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPicture(picture: PictureOfTheDayEntity)

    @Query("select * from asteroid")
    fun getAsteroidsList(): LiveData<List<AsteroidEntity>>

    @Query("select * from picture")
    fun getPicture(): LiveData<PictureOfTheDayEntity>

    @Query("delete from picture")
    fun deletePicture()

}