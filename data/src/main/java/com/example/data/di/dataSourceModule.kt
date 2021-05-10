package com.example.data.di

import com.example.dominio.datasource.IUserDomainLocalDataSource
import com.example.dominio.datasource.IUserDomainRemoteDataSource
import com.example.data.datasource.UserLocalDataSource
import com.example.data.datasource.UserRemoteDataSource
import org.koin.dsl.module

val localDataSourceModule = module {

    //cada vez que necesite el UserLocalDataSource, lo hare por medio de la interfaz  IUserDomainLocalDataSource, que actua como puente entre la conexion
    single<IUserDomainLocalDataSource> {
        UserLocalDataSource(get(),get())
    }
}

val remoteDataSourceModule = module {

    //cada vez que necesite el UserRemoteDataSource, lo hare por medio de la interfaz  IUserDomainRemoteDataSource, que actua como puente entre la conexion
    single<IUserDomainRemoteDataSource> {
        UserRemoteDataSource(get())
    }
}