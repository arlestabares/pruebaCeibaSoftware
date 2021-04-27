package com.example.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(
    tableName = "user_posts", foreignKeys = arrayOf(
        ForeignKey(
            entity = UserEntity::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("userId"),
            onDelete = CASCADE
        )
    )
)
data class UserPostsEntity(

    @ColumnInfo(name = "userId")
    val userId: Int,

    @PrimaryKey
    val id: Int,

    val title: String,

    val body: String

)