package com.example.dominio.datasource


import com.example.dominio.model.UserDomain
import com.example.dominio.model.UserPostsDomain

interface IUserDomainLocalDataSource {
    fun getUsersList(): List<UserDomain>
    fun getUsersListByName(name:String): List<UserDomain>
    fun getSizeList(): Int
    fun insertUserList(listUserDomain: List<UserDomain>)
    fun insertPostByUser(posts: List<UserPostsDomain>)
    suspend fun getAllPost(idUser:Int): List<UserPostsDomain>
}