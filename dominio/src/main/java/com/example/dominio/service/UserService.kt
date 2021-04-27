package com.example.dominio.service

import com.example.dominio.IConnectivity
import com.example.dominio.model.UserDomain
import repository.IUserRepository

class UserService(
    private val iUserRepository: IUserRepository,
    private val iConnectivity: IConnectivity
) : IUserService {

    override suspend fun getUsers(): List<UserDomain> {
        return iUserRepository.getAllUsers()
    }
}
