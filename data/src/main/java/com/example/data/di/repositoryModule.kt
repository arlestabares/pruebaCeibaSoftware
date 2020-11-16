package com.example.data.di

import com.example.data.repository.localrepository.RepositoryLocal
import org.koin.dsl.module
import repository.IUserLocalRepository

val repositoryModule = module {

    //cada vez que necesite el RepositoryLocal, lo hare por medio de la interfaz  IUserLocalRepository, que actua como puente entre la conexion
    single<IUserLocalRepository> { RepositoryLocal(get())
    }
}