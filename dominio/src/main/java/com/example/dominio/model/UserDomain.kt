package com.example.dominio.model


class UserDomain(
    val id: Int,
    val name: String,
    val phone: String,
    val mail: String,
    var posts:List<UserPostsDomain>
)



