package com.example.dominio.service

import com.example.dominio.model.UserDomain

interface IUserService {
    suspend fun getUsers(): List<UserDomain>
}
