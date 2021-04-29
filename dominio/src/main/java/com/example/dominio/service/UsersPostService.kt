package com.example.dominio.service

import com.example.dominio.model.UserPostsDomain
import com.example.dominio.repository.IUserDomainRepository

class UsersPostService(
    private val iUserDomainRepository: IUserDomainRepository
) : IUserPostService {

    override suspend fun getPostByUsers(idUser: Int): List<UserPostsDomain> {
        return iUserDomainRepository.getAllPost(idUser)
    }
}
