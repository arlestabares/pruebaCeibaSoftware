package com.example.pruebaceibasoftware.base

import android.app.Application
import com.example.data.di.*
import com.example.dominio.di.serviceModule
import com.example.pruebaceibasoftware.di.userPostsViewmodel
import com.example.pruebaceibasoftware.di.userViewmodel
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            //enviar al grafo un contexto
            androidContext(this@App)
            //module list
            modules(
                listOf(
                    dbModule,
                    localDataSourceModule,
                    remoteDataSourceModule,
                    serviceModule,
                    networkModule,
                    connection,
                    repositoryUserModule,
                    userViewmodel,
                    userPostsViewmodel
                )
            )
        }
    }
}