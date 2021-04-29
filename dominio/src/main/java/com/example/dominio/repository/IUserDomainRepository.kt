package com.example.dominio.repository

import com.example.dominio.model.UserDomain
import com.example.dominio.model.UserPostsDomain

interface IUserDomainRepository {
    suspend fun getAllUsers():List<UserDomain>
    suspend fun getAllUsersByName(name:String):List<UserDomain>
    suspend fun getAllPost(idUser:Int):List<UserPostsDomain>
}