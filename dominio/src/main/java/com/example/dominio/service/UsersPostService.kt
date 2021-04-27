package com.example.dominio.service

import com.example.dominio.model.UserPostsDomain
import repository.IUserRepository

class UsersPostService(
    private val iUserRepository: IUserRepository
) : IUserPostService {

    override suspend fun getPostByUsers(idUser: Int): List<UserPostsDomain> {
        return iUserRepository.getAllPost(idUser)
    }
}
