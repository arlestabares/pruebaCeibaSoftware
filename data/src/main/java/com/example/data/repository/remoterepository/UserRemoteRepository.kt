package com.example.data.repository.remoterepository

import com.example.data.dto.UserDTO
import com.example.data.dto.UserPostsDTO
import com.example.data.source.remote.retrofit.WebServiceApi
import com.example.dominio.model.UserDomain
import com.example.dominio.model.UserPostsDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.withContext
import repository.IUserRemoteRepository


class UserRemoteRepository(private val webServiceApi: WebServiceApi) : IUserRemoteRepository {

    override suspend fun getUsers(): List<UserDomain> {
        var users: List<UserDTO>? = null
        var usersD: List<UserPostsDTO>? = null


        if (webServiceApi.getUser().isSuccessful) {
            users = webServiceApi.getUser().body()

            var usersDomain = users!!.map {
                userDtoToDomain(it)
            }.asFlow()
            withContext(Dispatchers.IO) {
                val postByUser = usersDomain.map {
                    async {
                        webServiceApi.getAllPostsUser(it.id).body()!!.map {
                            userPostsDtoToDomain(it)
                        }
                    }.await()
                }

                usersDomain.zip(postByUser) { x, y ->
                    x.posts = y
                }

                //  users = usersDomain.toList()
            }

        }
        return users!!.map {
            userDtoToDomain(it)
        }

    }

    private fun userDtoToDomain(userDTO: UserDTO): UserDomain {
        return UserDomain(userDTO.id, userDTO.name, userDTO.phone, userDTO.email, null)
    }

    private fun userPostsDtoToDomain(userPostsDTO: UserPostsDTO): UserPostsDomain {
        return UserPostsDomain(
            userPostsDTO.userId,
            userPostsDTO.id,
            userPostsDTO.title,
            userPostsDTO.body
        )
    }

}


//Por cada usuario realizar una peticion para traer los Posts de cada uno de ellos y agregarle al userDomain una lista de PostsDomain


//Debo consumir los servicios de la interfaz WebService o metodos get, post
//convertirlos de DTO a Domain, cuando los convierto de DTO a domain debe recibirlos el Domain ,
// y en el Domain hacer la logica para insertarlos desde remoto a la base de datos local