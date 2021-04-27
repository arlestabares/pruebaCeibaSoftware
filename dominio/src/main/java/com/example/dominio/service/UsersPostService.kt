package com.example.dominio.service

import com.example.dominio.model.UserPostsDomain
import com.example.dominio.repository.IUserDomanRepository

class UsersPostService(
    private val iUserDomanRepository: IUserDomanRepository
) : IUserPostService {

    override suspend fun getPostByUsers(idUser: Int): List<UserPostsDomain> {
        return iUserDomanRepository.getAllPost(idUser)
    }
}
