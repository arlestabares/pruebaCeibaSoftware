package com.example.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "user_posts")
data class UserPostsEntity (

        @SerializedName("userId")
        val userId:Int,
        @PrimaryKey
        val id:Int,
        @SerializedName("title")
        val title :String,
        @SerializedName("body")
        val body:String

)