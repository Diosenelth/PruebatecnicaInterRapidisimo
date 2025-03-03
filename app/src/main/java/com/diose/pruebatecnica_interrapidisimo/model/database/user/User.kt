package com.diose.pruebatecnica_interrapidisimo.model.database.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "usuario") var usuario: String,
    @ColumnInfo(name = "version_web") var versioWeb: Int,
    @ColumnInfo(name = "identificacion") var identificacion: String,
    @ColumnInfo(name = "nombre") var nombre: String
)