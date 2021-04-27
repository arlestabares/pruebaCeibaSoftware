package com.example.dominio.repository

import com.example.dominio.model.UserDomain
import com.example.dominio.model.UserPostsDomain

interface IUserDomanRepository {
    suspend fun getAllUsers():List<UserDomain>
    suspend fun getAllPost(idUser:Int):List<UserPostsDomain>
}