package com.example.data.di

import android.content.Context
import androidx.room.Room
import com.example.data.source.local.dao.UserDao
import com.example.data.source.local.dao.UserPostsDao
import com.example.data.source.local.db.PruebaDB
import org.koin.dsl.module

val dbModule = module {
    //proveemos la base de datos
    single { provideDataBase(get()) }
    single { provideUserDao(get()) }
    single { provideUserPostDao(get()) }
}

fun provideDataBase(context: Context): PruebaDB {
    return Room.databaseBuilder(
        context,
        PruebaDB::class.java,
        "miDB"
    ).fallbackToDestructiveMigration()
        .allowMainThreadQueries()
        .build()
}

fun provideUserDao(pruebaDB: PruebaDB): UserDao {
    return pruebaDB.userDao()
}

fun provideUserPostDao(pruebaDB: PruebaDB): UserPostsDao {
    return pruebaDB.postUserDao()
}