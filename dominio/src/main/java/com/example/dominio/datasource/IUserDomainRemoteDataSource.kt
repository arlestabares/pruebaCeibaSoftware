package com.example.dominio.datasource

import com.example.dominio.model.UserDomain

interface IUserDomainRemoteDataSource {
    suspend fun getUsers(): List<UserDomain>
}