package com.example.data.source.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.data.model.UserEntity
import com.example.data.source.local.dao.UserDao


@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class PruebaDB : RoomDatabase() {
    abstract  fun userDao():UserDao

    companion object {

        //Singleton evita múltiples instancias de apertura de la base de datos en el
        // Mismo tiempo.
        @Volatile
        private var INSTANCE: PruebaDB? = null

        fun getDatabase(context: Context): PruebaDB {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PruebaDB::class.java,
                    "prueba_db"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}