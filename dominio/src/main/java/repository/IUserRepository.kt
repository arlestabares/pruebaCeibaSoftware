package repository

import com.example.dominio.model.UserDomain
import com.example.dominio.model.UserPostsDomain

interface IUserRepository {
    suspend fun getAllUsers():List<UserDomain>
    suspend fun getAllPost(idUser:Int):List<UserPostsDomain>
}