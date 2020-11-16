package com.example.dominio.service

import com.example.dominio.service.model.UserDomain
import excepciones.DomainException
import repository.IUserLocalRepository

class UserService(private val iUserLocalRepository: IUserLocalRepository) : IUserService {

    //Todo Implementar patron de disenio
    private fun insertUser(userDomain: UserDomain) {
        if (userDomain.id != null ) {
            if (iUserLocalRepository.getSizeList() == 0) {
                iUserLocalRepository.insertUser(userDomain)
            } else {
                if (!idUserExist(userDomain.id)) {
                    // repositorio insertar
                    iUserLocalRepository.insertUser(userDomain)
                } else {
                    throw  DomainException("usuario ya existe")
                }
            }
        } else {
            throw  DomainException("datos incompletos")
        }
    }


    // crear  una funcion donde reciba los parametros desde el main,
    // luego creo un objeto de tipo UserDomain y llamo a la funcion insertUser y lo inserta en base de datos
    override fun insertUser(id: Int, name: String, phone: String, mail: String) {
        insertUser(UserDomain(id, name,phone, mail))

    }


    private val userCount = emptyList<UserDomain>()

    private fun getUserItemCount(): Int {
        return userCount.size
    }

    // funcion que nos da el tamaño de la base de datos
    private fun getSizeDB(): List<UserDomain> {
        if (iUserLocalRepository.getSizeList() == 0) {
            throw DomainException("La lista se encuentra vacia")
        } else {
            return iUserLocalRepository.getUserList()
        }
    }

    private fun idUserExist(id: Int): Boolean {
        // repositorio.existe(id)
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
