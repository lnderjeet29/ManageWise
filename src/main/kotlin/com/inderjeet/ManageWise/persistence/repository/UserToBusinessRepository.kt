package com.inderjeet.ManageWise.persistence.repository

import com.inderjeet.ManageWise.persistence.entity.userToBusiness.UserToBusinessEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserToBusinessRepository : JpaRepository<UserToBusinessEntity, String>