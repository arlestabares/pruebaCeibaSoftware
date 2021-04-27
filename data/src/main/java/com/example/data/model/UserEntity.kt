package com.example.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_entity")
data class UserEntity (
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    val phone: String,
    val mail: String

//realizar un foreig key con UserPostsDTO


)