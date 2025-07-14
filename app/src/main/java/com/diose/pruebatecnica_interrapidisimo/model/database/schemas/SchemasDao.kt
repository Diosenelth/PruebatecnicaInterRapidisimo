package com.diose.pruebatecnica_interrapidisimo.model.database.schemas

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface SchemasDao {

    @Query("SELECT * FROM schemas")
    fun getAll(): List<Schemas>

    @Query("SELECT * FROM schemas WHERE id IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<Schemas>

    @Insert
    fun insertAll(localities: List<Schemas>)

    @Delete
    fun delete(localities: Schemas)
}