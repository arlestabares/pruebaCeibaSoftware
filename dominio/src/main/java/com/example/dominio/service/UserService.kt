package com.example.dominio.service

import com.example.dominio.IConnectivity
import com.example.dominio.model.UserDomain
import com.example.dominio.repository.IUserDomainRepository

class UserService(
    private val iUserDomainRepository: IUserDomainRepository,
    private val iConnectivity: IConnectivity
) : IUserService {

    override suspend fun getUsers(): List<UserDomain> {
        return iUserDomainRepository.getAllUsers()
    }

    override suspend fun getUsersBySearch(name: String): List<UserDomain> {
        return iUserDomainRepository.getAllUsersByName(name)
    }
}
