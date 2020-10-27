package com.example.data.repository.remoterepository

import com.example.data.model.UserEntity
import com.example.data.source.local.dao.UserDao
import com.example.data.source.remote.api.WebServiceUser

class RepositoryRemote(
        private val userDao: UserDao,
        private val webServiceUser: WebServiceUser
) {

    fun insertUsuario(userEntity: UserEntity) {

        userDao.insert(userEntity)
    }

    fun insertUsers(userEntity: List<UserEntity>) {
        userDao.inserListUser(userEntity)
    }

    fun getUserById(id: Int): UserEntity {
        return userDao.getUserById(id)
    }

    fun idUserExist(id: Int): Boolean {
        return getUserById(id) != null
    }


}