package com.inderjeet.ManageWise.rest.configuration

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType
import io.swagger.v3.oas.annotations.info.Contact
import io.swagger.v3.oas.annotations.info.Info
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import io.swagger.v3.oas.annotations.security.SecurityScheme
import io.swagger.v3.oas.annotations.servers.Server
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.EnableWebMvc

@Configuration
@EnableWebMvc
@OpenAPIDefinition(
    info = Info(
        title = "ManageWise",
        description = "A Business Management services API",
        contact = Contact(
            name = "inderjeet",
            email = "inderjeetdev33@gmail.com"
        ),
        version = "v1"
    ),
    servers = [
        Server(
            description = "Dev",
            url = "http://XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX.amazonaws.com"
        ),
        Server(
            description = "localhost:8080",
            url = "http://localhost:8080"
        )
    ],
    security = [SecurityRequirement(name = "bearerAuth")]
)
@SecurityScheme(
    name = "bearerAuth",
    `in` = SecuritySchemeIn.HEADER,
    type = SecuritySchemeType.HTTP,
    scheme = "bearer",
    bearerFormat = "JWT"
)
class SwaggerOpenApiConfig{}