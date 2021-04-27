package com.example.data.datasource

import com.example.data.dto.UserPostsDTO
import com.example.dominio.model.UserDomain
import com.example.dominio.model.UserPostsDomain

interface IUserLocalDataSource {
    fun getUsersList(): List<UserDomain>
    fun getSizeList(): Int
    fun insertUserList(listUserDomain: List<UserDomain>)
    fun insertPostByUser(posts: List<UserPostsDomain>)
    suspend fun getAllPost(idUser:Int): List<UserPostsDomain>
}