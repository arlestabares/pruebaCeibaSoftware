package com.example.data.di

import com.example.data.repository.UsersRepository
import org.koin.dsl.module
import repository.IUserRepository

val repositoryUserModule = module {
    single<IUserRepository> {
        UsersRepository(get(), get())
    }
}