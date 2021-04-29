package com.example.data.repository

import com.example.dominio.datasource.IUserDomainLocalDataSource
import com.example.dominio.datasource.IUserDomainRemoteDataSource
import com.example.dominio.model.UserDomain
import com.example.dominio.model.UserPostsDomain
import com.example.dominio.repository.IUserDomainRepository

class UsersRepository(
    private var localDataSource: IUserDomainLocalDataSource,
    private var domainRemoteDataSource: IUserDomainRemoteDataSource
) : IUserDomainRepository {


    override suspend fun getAllUsers(): List<UserDomain> {
        val users: List<UserDomain>
        if (localDataSource.getSizeList() != 0) {
            users = localDataSource.getUsersList()
        } else {
            users = domainRemoteDataSource.getUsers()
            localDataSource.insertUserList(users)
            users.forEach {
                localDataSource.insertPostByUser(it.posts)
            }
        }
        return users
    }

    override suspend fun getAllUsersByName(name: String): List<UserDomain> {
        return localDataSource.getUsersListByName(name)
    }

    override suspend fun getAllPost(idUser: Int): List<UserPostsDomain> {
        return localDataSource.getAllPost(idUser)
    }

}