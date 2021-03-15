package com.example.data.di

import com.example.data.network.Network
import com.example.dominio.IConnectivity
import org.koin.dsl.module


val connection = module {
    single<IConnectivity> { Network(get()) }
}