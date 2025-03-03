package com.diose.pruebatecnica_interrapidisimo.model.database.localities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "localities")
data class Localities(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "abreviacionCiudad") val abreviacionCiudad: String?,
    @ColumnInfo(name = "nombre") val nombre: String?,
)