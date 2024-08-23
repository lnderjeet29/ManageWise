package com.inderjeet.ManageWise.rest.controller

import com.inderjeet.ManageWise.business.dto.clientDto.CreateClientRequestDto
import com.inderjeet.ManageWise.business.gateway.ClientService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/client")
class ClientController(
    private val clientService: ClientService
) {

    @PostMapping
    fun createClient(
        @RequestBody createClientRequestDto: CreateClientRequestDto
    ): ResponseEntity<String> {
        return try {
            clientService.createClient(createClientRequestDto)
            ResponseEntity.ok("Client created successfully.")
        } catch (e: Exception) {
            e.printStackTrace()
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while creating the client.")
        }
    }
}