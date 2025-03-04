package com.diose.pruebatecnica_interrapidisimo.model.database.localities

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface LocalitiesDao {
    @Query("SELECT * FROM localities")
    fun getAll(): List<Localities>

    @Query("SELECT * FROM localities WHERE id IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<Localities>

    @Insert
    fun insertAll(localities: List<Localities>)

    @Delete
    fun delete(localities: Localities)
}