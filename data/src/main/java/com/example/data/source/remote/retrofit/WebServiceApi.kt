package com.example.data.source.remote.retrofit

import com.example.data.dto.UserDTO
import com.example.data.dto.UserPostsDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WebServiceApi {

    @GET("users")
    suspend fun getUser(): Response<List<UserDTO>>

    @GET("posts")
    suspend fun getAllPostsUser(@Query("userId") userId: Int): Response<List<UserPostsDTO>>


}

//crear las funciones o API y definir metodos los cuales voy a consultar
//como getUser, GetPost,
