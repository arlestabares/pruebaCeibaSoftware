package repository

import com.example.dominio.model.UserDomain

interface IUserRemoteRepository  {

    suspend fun getUsers():List<UserDomain>

}