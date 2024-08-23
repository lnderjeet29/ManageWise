package com.inderjeet.ManageWise.business.gateway

import com.inderjeet.ManageWise.business.dto.userDto.CreateUserDto

interface UserService {
    fun createUser(createUserDto: CreateUserDto, userHash: String)
    fun getUserByHash(userHash: String)
    fun updateUserByHash(userHash: String)
}