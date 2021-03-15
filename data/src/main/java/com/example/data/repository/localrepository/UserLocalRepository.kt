package com.example.data.repository.localrepository

import com.example.data.model.UserEntity
import com.example.data.source.local.dao.UserDao
import com.example.dominio.model.UserDomain
import repository.IUserLocalRepository

class UserLocalRepository(private val userDao: UserDao): IUserLocalRepository {


    override fun getUser(id: Int): UserDomain {
        return userEntityToDomain(userDao.getUserById(id))
    }

    override fun idExistUser(id: Int): Boolean {
        return getUser(id) != null

    }

    override fun insertUser(userDomain: UserDomain) {
      return  insertUser(userDomainToEntity(userDomain))
    }

    override fun insertUserList(listUserDomain: List<UserDomain>) {
        val usersEntity = listUserDomain.map {
            userDomainToEntity(it)
        }
        insertListUsers(usersEntity)
    }

    override fun getUsersList(): List<UserDomain> = userDao.getUserList().map {
        userEntityToDomain(it)
    }

    override fun getSizeList(): Int {
         return getUsersList().size
    }

    private fun userEntityToDomain(userEntity: UserEntity): UserDomain {

        return UserDomain(userEntity.id, userEntity.name, userEntity.phone, userEntity.mail,null)
    }

    private fun userDomainToEntity(userDomain: UserDomain): UserEntity {
        return UserEntity(userDomain.id, userDomain.name, userDomain.phone, userDomain.mail)
    }


    private fun insertUser(userEntity: UserEntity) {
        userDao.insertUser(userEntity)

    }

    private fun insertListUsers(userEntities: List<UserEntity>) {
        userDao.inserListUser(userEntities)
    }

    private fun getUserDbById(id: Int): UserEntity {
        return userDao.getUserById(id)
    }
}