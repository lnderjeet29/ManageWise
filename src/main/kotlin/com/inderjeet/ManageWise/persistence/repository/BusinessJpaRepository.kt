package com.inderjeet.ManageWise.persistence.repository

import com.inderjeet.ManageWise.persistence.entity.BusinessEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BusinessJpaRepository:JpaRepository<BusinessEntity,String>