package com.diose.pruebatecnica_interrapidisimo.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import com.diose.pruebatecnica_interrapidisimo.model.database.localities.Localities
import com.diose.pruebatecnica_interrapidisimo.model.database.localities.LocalitiesDao
import com.diose.pruebatecnica_interrapidisimo.model.database.schemas.Schemas
import com.diose.pruebatecnica_interrapidisimo.model.database.schemas.SchemasDao
import com.diose.pruebatecnica_interrapidisimo.model.database.user.User
import com.diose.pruebatecnica_interrapidisimo.model.database.user.UserDao

@Database(entities = [User::class, Localities::class, Schemas::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun localities(): LocalitiesDao
    abstract fun schemas(): SchemasDao

    companion object {
        private const val DB_NAME = "database.db"
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            INSTANCE = null
            INSTANCE =
                databaseBuilder(context.applicationContext, AppDatabase::class.java, DB_NAME)
                    .allowMainThreadQueries()
                    .build()
            return INSTANCE!!
        }
    }
}