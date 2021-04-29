package com.example.data.datasource

import com.example.data.converters.Converters
import com.example.data.model.UserEntity
import com.example.data.source.local.dao.UserDao
import com.example.data.source.local.dao.UserPostsDao
import com.example.dominio.datasource.IUserDomainLocalDataSource
import com.example.dominio.model.UserDomain
import com.example.dominio.model.UserPostsDomain


//solo hace procesos de bases de dato
class UserLocalDataSource(private val userDao: UserDao, private val userPostsDao: UserPostsDao) :
    IUserDomainLocalDataSource {

    private var converters: Converters

    init {
        converters = Converters()
    }


    override fun insertUserList(listUserDomain: List<UserDomain>) {
        val usersEntity = listUserDomain.map {
            converters.userDomainToEntity(it)
        }
        insertListUsers(usersEntity)
    }

    override fun insertPostByUser(posts: List<UserPostsDomain>) {
        userPostsDao.insertPostsList(posts.map {
            converters.userPostDomainToEntity(it)
        })
    }

    override suspend fun getAllPost(idUser: Int): List<UserPostsDomain> {
        return userPostsDao.getPostsUserById(idUser).map {
            converters.userPostEntityToDomain(it)
        }
    }

    override fun getUsersList(): List<UserDomain> = userDao.getUserList().map {
        converters.userEntityToDomain(it)
    }

    override fun getUsersListByName(name: String): List<UserDomain> =
        userDao.getUserListByName(name).map {
            converters.userEntityToDomain(it)
        }

    override fun getSizeList(): Int {
        return getUsersList().size
    }

    private fun insertListUsers(userEntities: List<UserEntity>) {
        userDao.inserListUser(userEntities)
    }

}