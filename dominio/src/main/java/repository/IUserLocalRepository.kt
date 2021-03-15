package repository

import com.example.dominio.model.UserDomain

interface IUserLocalRepository {


    fun getUser(id: Int): UserDomain

    fun idExistUser(id: Int): Boolean

    fun insertUser(userDomain: UserDomain)

    fun insertUserList(userDomain: List<UserDomain>)

    fun getUsersList(): List<UserDomain>

    fun getSizeList():Int




}