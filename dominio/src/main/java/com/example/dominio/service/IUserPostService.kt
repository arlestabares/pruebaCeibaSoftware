package com.example.dominio.service

import com.example.dominio.model.UserPostsDomain

interface IUserPostService {
    suspend fun getPostByUsers(idUser:Int): List<UserPostsDomain>
}
