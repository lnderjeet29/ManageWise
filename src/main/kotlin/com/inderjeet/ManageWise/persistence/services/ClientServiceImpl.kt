package com.inderjeet.ManageWise.persistence.services

import com.inderjeet.ManageWise.business.dto.clientDto.CreateClientRequestDto
import com.inderjeet.ManageWise.business.gateway.ClientService
import com.inderjeet.ManageWise.persistence.repository.BusinessJpaRepository
import com.inderjeet.ManageWise.persistence.repository.ClientJpaRepository
import com.inderjeet.ManageWise.persistence.repository.UserJpaRepository
import com.inderjeet.ManageWise.rest.exceptionHandler.ServerError
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class ClientServiceImpl(
    private val clientJpaRepository: ClientJpaRepository,
    private val businessJpaRepository: BusinessJpaRepository,
    private val userJpaRepository: UserJpaRepository
):ClientService {

    @Transactional
    override fun createClient(createClientRequestDto: CreateClientRequestDto) {
        try {
            TODO("implementation of create client")
        } catch (e: Exception) {
            throw ServerError("An unexpected error occurred: ${e.message}")
        }
    }
}