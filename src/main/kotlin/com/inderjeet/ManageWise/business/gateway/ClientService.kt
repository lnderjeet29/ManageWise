package com.inderjeet.ManageWise.business.gateway

import com.inderjeet.ManageWise.business.dto.clientDto.CreateClientRequestDto

interface ClientService {
    fun createClient(createClientRequestDto: CreateClientRequestDto)
}