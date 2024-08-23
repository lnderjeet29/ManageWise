package com.inderjeet.ManageWise.rest.controller

import com.inderjeet.ManageWise.business.dto.businessDto.CreateBusinessDTO
import com.inderjeet.ManageWise.business.gateway.BusinessService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/business")
class BusinessController(val businessService: BusinessService) {

    @PostMapping
    fun createBusiness(
        @RequestAttribute(name = "userHash") userHash: String,
        @RequestBody createBusinessDTO: CreateBusinessDTO
    ): ResponseEntity<String> {
        return try {
            businessService.createBusiness(createBusinessDTO, userHash =  userHash)
            ResponseEntity.ok().body("Business Created Successfully.")
        } catch (e: Exception) {
            e.printStackTrace()
            ResponseEntity.status(401).body("Invalid User.")
        }
    }
}