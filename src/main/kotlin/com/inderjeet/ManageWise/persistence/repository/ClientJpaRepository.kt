package com.inderjeet.ManageWise.persistence.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ClientJpaRepository : JpaRepository<com.inderjeet.ManageWise.persistence.entity.ClientEntity, String> {
    fun existsByUserHashAndBusinessHash(userHash: String?, businessHash: String): Boolean
}