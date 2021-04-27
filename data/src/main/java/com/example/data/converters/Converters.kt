package com.example.data.converters

import com.example.data.dto.UserDTO
import com.example.data.dto.UserPostsDTO
import com.example.data.model.UserEntity
import com.example.data.model.UserPostsEntity
import com.example.dominio.model.UserDomain
import com.example.dominio.model.UserPostsDomain

class Converters {

    fun userDtoToDomain(userDTO: UserDTO): UserDomain {
        return UserDomain(userDTO.id, userDTO.name, userDTO.phone, userDTO.email, listOf())
    }

    fun userPostsDtoToDomain(userPostsDTO: UserPostsDTO): UserPostsDomain {
        return UserPostsDomain(
            userPostsDTO.userId,
            userPostsDTO.id,
            userPostsDTO.title,
            userPostsDTO.body
        )
    }


    fun userEntityToDomain(userEntity: UserEntity): UserDomain {
        return UserDomain(
            userEntity.id,
            userEntity.name,
            userEntity.phone,
            userEntity.mail,
            listOf()
        )
    }

    fun userDomainToEntity(userDomain: UserDomain): UserEntity {
        return UserEntity(userDomain.id, userDomain.name, userDomain.phone, userDomain.mail)
    }

    fun userPostDomainToEntity(userPostsDomain: UserPostsDomain): UserPostsEntity {
        return UserPostsEntity(
            userPostsDomain.userId,
            userPostsDomain.id,
            userPostsDomain.title,
            userPostsDomain.body
        )
    }


    fun userPostEntityToDomain(userPostsEntity: UserPostsEntity): UserPostsDomain {
        return UserPostsDomain(
            userPostsEntity.userId,
            userPostsEntity.id,
            userPostsEntity.title,
            userPostsEntity.body
        )
    }


}