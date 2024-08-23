package com.inderjeet.ManageWise.persistence.repository

import com.inderjeet.ManageWise.persistence.entity.userToBusiness.UserToBusinessAccessEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserToBusinessAccessRepository : JpaRepository<UserToBusinessAccessEntity, String>