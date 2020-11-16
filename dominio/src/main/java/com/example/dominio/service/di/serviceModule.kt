package com.example.dominio.service.di

import com.example.dominio.service.IUserService
import com.example.dominio.service.UserService
import org.koin.dsl.module

val serviceModule = module {

    //cada vez que necesite el UserService, lo hare por medio de la interfaz  IUserService, que actua como puente entre la conexion
    single <IUserService>{ UserService(get()) }
}