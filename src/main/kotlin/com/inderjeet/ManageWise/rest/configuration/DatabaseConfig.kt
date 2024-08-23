package com.inderjeet.ManageWise.rest.configuration

import com.inderjeet.ManageWise.persistence.entity.crendential.DbCredentials
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.datasource.DriverManagerDataSource
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest
import javax.sql.DataSource

@Configuration
class DatabaseConfig() {

    lateinit var dbCredentials: DbCredentials

    @Bean
    fun dataSource(): DataSource {

        try {
            val client = SecretsManagerClient.builder()
                .region(Region.of(ConfigConstant.REGION))
                .build()

            val getSecretValueRequest = GetSecretValueRequest.builder()
                .secretId(ConfigConstant.DB_SECRET_NAME)
                .build()

            val getSecretValueResponse = client.getSecretValue(getSecretValueRequest)
            val secretString = getSecretValueResponse.secretString()
            val objectMapper = jacksonObjectMapper()

            dbCredentials = objectMapper.readValue(secretString)

            val dataSource = DriverManagerDataSource()
            dataSource.setDriverClassName(ConfigConstant.DRIVER_CLASS_NAME)
            dataSource.url = dbCredentials.url
            dataSource.username = dbCredentials.username
            dataSource.password = dbCredentials.password

            return dataSource
        } catch (e: Exception) {
            e.printStackTrace()
            throw RuntimeException("Failed to initialize DataSource", e)
        }
    }
}

