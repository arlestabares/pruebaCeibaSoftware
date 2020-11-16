package com.example.data.repository.remoterepository

import com.example.data.model.UserEntity
import com.example.data.source.local.dao.UserDao
import com.example.data.source.remote.api.WebServiceUser

class RepositoryRemote(
        private val webServiceUser: WebServiceUser
) {





}
//Debo consumir los servicios de la interfaz WebService o metodos get, post
//convertirlos de DTO a Domain, cuando los convierto de DTO a domain debe resibirlos el Domain , y en el Domain hacer la logica
// para insertarlos desde remoto a la base de datos local