package com.example.data.datasource

import com.example.data.converters.Converters
import com.example.data.source.remote.retrofit.WebServiceApi
import com.example.dominio.datasource.IUserDomainRemoteDataSource
import com.example.dominio.model.UserDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext


class UserRemoteDataSource(private val webServiceApi: WebServiceApi) : IUserDomainRemoteDataSource {

    private var converters: Converters

    init {
        converters = Converters()
    }

    override suspend fun getUsers(): List<UserDomain> {

        var users: List<UserDomain> = listOf()

        if (webServiceApi.getUser().isSuccessful) {
            users = webServiceApi.getUser().body()?.let {
                it.let {
                    it.map {
                        converters.userDtoToDomain(it)
                    }
                }
            } ?: listOf()
        }

        users.forEach {
            withContext(Dispatchers.IO) {
                async {
                    val postByUser = webServiceApi.getAllPostsUser(it.id)
                    it.posts = postByUser.body().let {
                        it?.map {
                            converters.userPostsDtoToDomain(it)
                        } ?: listOf()
                    }
                }.await()
            }
        }
        return users
    }


}


//Por cada usuario realizar una peticion para traer los Posts de cada uno de ellos y agregarle al userDomain una lista de PostsDomain


//Debo consumir los servicios de la interfaz WebService o metodos get, post
//convertirlos de DTO a Domain, cuando los convierto de DTO a domain debe recibirlos el Domain ,
// y en el Domain hacer la logica para insertarlos desde remoto a la base de datos local
