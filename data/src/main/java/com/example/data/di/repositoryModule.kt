package com.example.data.di

import com.example.data.repository.UsersRepository
import org.koin.dsl.module
import com.example.dominio.repository.IUserDomainRepository

val repositoryUserModule = module {
    single<IUserDomainRepository> {
        UsersRepository(get(), get())
    }
}