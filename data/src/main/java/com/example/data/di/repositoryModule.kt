package com.example.data.di

import com.example.data.repository.localrepository.RepositoryLocal
import org.koin.dsl.module

val repositoryModule = module {
    single {
        RepositoryLocal(get())
    }
}