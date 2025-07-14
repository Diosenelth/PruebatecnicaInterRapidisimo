package com.diose.pruebatecnica_interrapidisimo.model.database.schemas

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "schemas")
data class Schemas (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") var id: Int = 0,
    @ColumnInfo(name = "batchSize") val batchSize: Int = 0,
    @ColumnInfo(name = "numeroCampos")val numeroCampos: Int,

    @ColumnInfo(name = "filtro")val filtro: String,

    @ColumnInfo(name = "fechaActualizacion")val fechaActualizacionSincro: String,

    @ColumnInfo(name = "queryCreacion")val queryCreacion: String,

    @ColumnInfo(name = "nombreTabla")val nombreTabla: String,

    @ColumnInfo(name = "pk") val pk: String,
    )
