package com.inderjeet.ManageWise.persistence.services

import com.inderjeet.ManageWise.business.dto.userDto.CreateUserDto
import com.inderjeet.ManageWise.business.gateway.UserService
import com.inderjeet.ManageWise.persistence.entity.UserEntity
import com.inderjeet.ManageWise.persistence.repository.UserJpaRepository
import com.inderjeet.ManageWise.rest.exceptionHandler.BadApiRequest
import com.inderjeet.ManageWise.rest.exceptionHandler.ResourceNotFound
import com.inderjeet.ManageWise.rest.exceptionHandler.ServerError
import org.springframework.dao.DataAccessException
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(val userJpaRepository: UserJpaRepository) : UserService {

    override fun createUser(createUserDto: CreateUserDto, userHash: String) {
        if (userJpaRepository.existsById(userHash)) {
            throw BadApiRequest("User already exists.")
        }
        try {
            val user = UserEntity(createUserDto = createUserDto, userHash = userHash)
            userJpaRepository.save(user)
        } catch (e: DataAccessException) {
            e.printStackTrace()
            throw ResourceNotFound("Error saving user to the database: ${e.message}")
        } catch (e: Exception) {
            throw ServerError("Something went wrong: ${e.message}")
        }
    }

    override fun getUserByHash(userHash: String) {
        TODO("Not yet implemented")
    }

    override fun updateUserByHash(userHash: String) {
        TODO("Not yet implemented")
    }
}