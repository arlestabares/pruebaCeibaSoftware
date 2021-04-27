package com.example.data.source.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.model.UserPostsEntity
import retrofit2.http.GET

@Dao
interface UserPostsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertPostsUser(userPostsEntity: UserPostsEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertPostsList(userPostsEntity: List<UserPostsEntity>)
    @Query("SELECT * FROM user_posts WHERE userId = :idUser")
    fun getPostsUserById(idUser:Int):List<UserPostsEntity>

}