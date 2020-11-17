package com.udacity.asteroid.radar.data.storage.database

import androidx.room.*
import com.udacity.asteroid.radar.data.storage.entity.AsteroidEntity
import com.udacity.asteroid.radar.data.storage.entity.PictureEntity

@Dao
interface AsteroidDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg asteroids: AsteroidEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAsteroid(asteroid: AsteroidEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPicture(picture: PictureEntity)

    @Query("select * from asteroid")
    fun getAsteroidList(): List<AsteroidEntity>

    @Query("select * from picture")
    fun getPicture(): PictureEntity

    @Query("delete from picture")
    fun deletePicture()

}