package com.example.data.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.model.UserEntity

@Dao
interface UserDao {


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertUser(userEntity: UserEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun inserListUser(userEntity: List<UserEntity>)

    @Query("SELECT * FROM   user_entity WHERE id = :id LIMIT 1")
    fun getUserById(id: Int): UserEntity

    @Query("SELECT * FROM  user_entity  ORDER BY name ASC ")
    fun getUserList(): List<UserEntity>

    @Query("SELECT * FROM user_entity WHERE name LIKE '%' ||  :name || '%'")
    fun getUserListByName(name:String): List<UserEntity>

    //fun save(body: List<UserEntity>)

   // fun hasUser(freshTimeout: Long): Any
}