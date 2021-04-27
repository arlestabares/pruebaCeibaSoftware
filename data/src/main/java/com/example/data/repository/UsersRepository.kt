package com.example.data.repository

import com.example.data.datasource.IUserLocalDataSource
import com.example.data.datasource.IUserRemoteDataSource
import com.example.dominio.model.UserDomain
import com.example.dominio.model.UserPostsDomain
import repository.IUserRepository

class UsersRepository(
    private var localDataSource: IUserLocalDataSource,
    private var remoteDataSource: IUserRemoteDataSource
) : IUserRepository {


    override suspend fun getAllUsers(): List<UserDomain> {
        val users: List<UserDomain>
        if (localDataSource.getSizeList() != 0) {
            users = localDataSource.getUsersList()
        } else {
            users = remoteDataSource.getUsers()
            localDataSource.insertUserList(users)
            users.forEach {
                localDataSource.insertPostByUser(it.posts)
            }
        }
        return users
    }

    override suspend fun getAllPost(idUser: Int): List<UserPostsDomain> {
        return localDataSource.getAllPost(idUser)
    }

}