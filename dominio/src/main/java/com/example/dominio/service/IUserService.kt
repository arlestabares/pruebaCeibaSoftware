package com.example.dominio.service

import com.example.dominio.service.model.UserDomain

interface IUserService {


    fun insertUser(id:Int,name:String,phone:String, mail:String)

}
