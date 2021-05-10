package com.example.dominio.service

import com.example.dominio.IConnectivity
import com.example.dominio.model.UserDomain
import com.example.dominio.repository.IUserDomainRepository

class UserService(
    private val iUserDomainRepository: IUserDomainRepository,
    private val iConnectivity: IConnectivity
) : IUserService {

    override suspend fun getUsers(): List<UserDomain> {
        return iUserDomainRepository.getAllUsers()
    }

    override suspend fun getUsersBySearch(name: String): List<UserDomain> {
        if (iConnectivity.hasNetwork()){
            return iUserDomainRepository.getAllUsersByName(name)
        }
        return listOf()
    }

    fun sumar(numero1: Int, numero2:Int):Int{
        var resul  = numero1 + numero2 + 1
        if (numero1 != 1){
             resul  = numero1 + numero2
        }
        return resul
    }
}
