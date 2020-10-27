package com.example.pruebaceibasoftware

import android.app.Application
import com.example.data.di.dbModule
import com.example.data.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            //enviar al grafo un contexto
            androidContext(this@App)
            //module list
            modules(listOf(dbModule, repositoryModule,))
        }
    }
}