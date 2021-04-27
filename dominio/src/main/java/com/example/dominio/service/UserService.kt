package com.example.dominio.service

import com.example.dominio.IConnectivity
import com.example.dominio.model.UserDomain
import com.example.dominio.repository.IUserDomanRepository

class UserService(
    private val iUserDomanRepository: IUserDomanRepository,
    private val iConnectivity: IConnectivity
) : IUserService {

    override suspend fun getUsers(): List<UserDomain> {
        return iUserDomanRepository.getAllUsers()
    }
}
