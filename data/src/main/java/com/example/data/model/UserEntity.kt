package com.example.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "user_entity")
data class UserEntity (
    @PrimaryKey
    val id: Int,
    @SerializedName("name")
    @ColumnInfo(name = "name")
    val name: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("mail")
    val mail: String

//realizar un foreig key con UserPostsDTO


)