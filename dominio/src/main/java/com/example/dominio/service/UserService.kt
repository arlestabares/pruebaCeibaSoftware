package com.example.dominio.service

import com.example.dominio.service.model.UserDomain
import excepciones.DomainException
import repository.IUserLocalRepository

class UserService(
    private val iUserLocalRepository: IUserLocalRepository,
) {

    private fun insertUser(id: Int, userDomain: UserDomain) {
        if (userDomain.id != null && userDomain.name != null) {
            if (!idUserExist(id)) {
                // repositorio insertar
                iUserLocalRepository.insertUser(userDomain)
            } else {
                throw  DomainException("usuario ya existe")
            }
        }
    }

    private val userCount = emptyList<UserDomain>()

    private  fun getUserItemCount(): Int{
        if (userCount != null){
            return userCount.size
        }else{
            return 0
        }
    }

    // funcion que nos da el tamaño de la base de datos
    private fun sizeDB(): List<UserDomain> {
        if (iUserLocalRepository.getSizeList() == 0) {
            throw DomainException("La lista se encuentra vacia")
        } else {
            return iUserLocalRepository.getUserList()
        }


    }

    private fun idUserExist(id: Int): Boolean {
        // reposirio.existe(id)
        return iUserLocalRepository.idExistUser(id)
    }

    private fun getUser(id: Int): UserDomain {
        return iUserLocalRepository.getUser(id)

    }

    private fun getUserList(): List<UserDomain> {
        return iUserLocalRepository.getUserList()

    }

    private fun insertListUser(userDomain: List<UserDomain>) {
        iUserLocalRepository.insertUserList(userDomain)
    }

}

//Validar si la lista en base de datos esta vacia
//si es asi, devolver una excepcion de dominio diciendo que la lista esta vacia
// de lo contrario retornar una lista de usuarios de dominio
