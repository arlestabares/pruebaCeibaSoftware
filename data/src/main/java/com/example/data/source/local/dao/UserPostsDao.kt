package com.example.data.source.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserPostsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertPosts(userPostsDao: UserPostsDao)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertPostsList(userPostsDao: List<UserPostsDao>)

    @Query("SELECT * FROM user_posts ORDER BY title ASC")
    fun getPostsUser():LiveData<List<UserPostsDao>>
}