package com.inderjeet.ManageWise.rest.exceptionHandler

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(BadApiRequest::class)
    fun badRequestException(e: BadApiRequest): ResponseEntity<String> {
        return ResponseEntity(e.message.toString(), HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(ServerError::class)
    fun severException(e: ServerError): ResponseEntity<String> {
        return ResponseEntity(e.message.toString(), HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(ResourceNotFound::class)
    fun resourceNotFoundException(e: ResourceNotFound): ResponseEntity<String> {
        return ResponseEntity(e.message.toString(), HttpStatus.NOT_FOUND)
    }
}