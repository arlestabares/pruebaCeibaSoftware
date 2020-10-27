package com.example.data.source.remote.api

import UserDTO
import retrofit2.Call
import retrofit2.http.GET

interface WebServiceUser {

    @GET("/users")
    fun getUser(id:Int): Call<UserDTO>
}