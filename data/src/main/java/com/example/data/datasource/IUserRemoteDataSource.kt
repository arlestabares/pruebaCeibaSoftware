package com.example.data.datasource

import com.example.dominio.model.UserDomain

interface IUserRemoteDataSource {
    suspend fun getUsers(): List<UserDomain>
}