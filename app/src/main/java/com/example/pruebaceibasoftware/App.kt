package com.example.pruebaceibasoftware

import android.app.Application
import com.example.data.di.*
import com.example.dominio.di.serviceModule
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
                    dbModule, repositoryLocalModule, repositoryRepositoryModule, serviceModule, networkModule,connection
                )
            )
        }
    }
}