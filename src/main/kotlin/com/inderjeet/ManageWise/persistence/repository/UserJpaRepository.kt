package com.inderjeet.ManageWise.persistence.repository

import com.inderjeet.ManageWise.persistence.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserJpaRepository :JpaRepository<UserEntity,String>{
}