package com.example.data.di

import com.example.data.repository.UsersRepository
import org.koin.dsl.module
import com.example.dominio.repository.IUserDomanRepository

val repositoryUserModule = module {
    single<IUserDomanRepository> {
        UsersRepository(get(), get())
    }
}