package com.inderjeet.ManageWise.rest.controller

import com.inderjeet.ManageWise.business.dto.userDto.CreateUserDto
import com.inderjeet.ManageWise.business.gateway.UserService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/user")
class UserController(val userService: UserService) {

    @Operation(
        summary = "Create a new user",
        description = "Requires an Authorization header",
        security = [SecurityRequirement(name = "bearerAuth")]
    )
    @PostMapping
    fun createUser(
        @RequestAttribute(name = "userHash") userHash: String,
        @RequestBody createUserDto: CreateUserDto): ResponseEntity<String> {
        return try {
            userService.createUser(createUserDto,userHash)
            ResponseEntity.ok().body("User successfully created.")
        } catch (e: Exception) {
            e.printStackTrace()
            ResponseEntity.status(401).body("Invalid User.")
        }
    }

    @GetMapping("/{userHash}")
    fun getUserById(@PathVariable(required = true) userHash: String): ResponseEntity<Nothing> {
        // Your implementation
        return ResponseEntity.ok().body(null)
    }

    @PatchMapping("/{userHash}")
    fun updateUser(@PathVariable(required = true) userHash: String): ResponseEntity<Nothing> {
        //your implementation
        return ResponseEntity.ok().body(null)
    }
}