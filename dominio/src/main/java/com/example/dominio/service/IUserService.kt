package com.example.dominio.service

import com.example.dominio.model.UserDomain

interface IUserService {


    fun insertUser(id: Int, name: String, phone: String, mail: String)

    suspend fun getUsers(): List<UserDomain>

}
