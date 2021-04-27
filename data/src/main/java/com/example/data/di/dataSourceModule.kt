package com.example.data.di

import com.example.dominio.datasource.IUserDomainLocalDataSource
import com.example.dominio.datasource.IUserDomainRemoteDataSource
import com.example.data.datasource.UserLocalDataSource
import com.example.data.datasource.UserRemoteDataSource
import org.koin.dsl.module

val localDataSourceModule = module {

    //cada vez que necesite el RepositoryLocal, lo hare por medio de la interfaz  IUserLocalRepository, que actua como puente entre la conexion
    single<IUserDomainLocalDataSource> {
        UserLocalDataSource(get(),get())
    }
}

val remoteDataSourceModule = module {

    //cada vez que necesite el RepositoryLocal, lo hare por medio de la interfaz  IUserLocalRepository, que actua como puente entre la conexion
    single<IUserDomainRemoteDataSource> {
        UserRemoteDataSource(get())
    }
}