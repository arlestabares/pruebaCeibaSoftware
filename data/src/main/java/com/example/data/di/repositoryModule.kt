package com.example.data.di

import com.example.data.repository.localrepository.UserLocalRepository
import com.example.data.repository.remoterepository.UserRemoteRepository
import org.koin.dsl.module
import repository.IUserLocalRepository
import repository.IUserRemoteRepository

val repositoryLocalModule = module {

    //cada vez que necesite el RepositoryLocal, lo hare por medio de la interfaz  IUserLocalRepository, que actua como puente entre la conexion
    single<IUserLocalRepository> {
        UserLocalRepository(get())
    }
}

val repositoryRepositoryModule = module {

    //cada vez que necesite el RepositoryLocal, lo hare por medio de la interfaz  IUserLocalRepository, que actua como puente entre la conexion
    single<IUserRemoteRepository> {
        UserRemoteRepository(get())
    }
}