package com.example.pruebaceibasoftware.di

import com.example.pruebaceibasoftware.viewmodels.PostViewModel
import com.example.pruebaceibasoftware.viewmodels.UserViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val userViewmodel = module {
    viewModel {
        UserViewModel(get())
    }
}

val userPostsViewmodel = module {
    viewModel {
        PostViewModel(get())
    }
}