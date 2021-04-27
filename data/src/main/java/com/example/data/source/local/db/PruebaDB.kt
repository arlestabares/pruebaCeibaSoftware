package com.example.data.source.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.data.model.UserEntity
import com.example.data.model.UserPostsEntity
import com.example.data.source.local.dao.UserDao
import com.example.data.source.local.dao.UserPostsDao


@Database(entities = [UserEntity::class,UserPostsEntity::class], version =3, exportSchema = false)
abstract class PruebaDB : RoomDatabase() {
    abstract  fun userDao():UserDao
    abstract  fun postUserDao():UserPostsDao

}