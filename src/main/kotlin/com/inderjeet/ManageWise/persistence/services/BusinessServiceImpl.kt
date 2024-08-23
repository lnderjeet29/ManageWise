package com.inderjeet.ManageWise.persistence.services

import com.inderjeet.ManageWise.business.dto.businessDto.CreateBusinessDTO
import com.inderjeet.ManageWise.business.gateway.BusinessService
import com.inderjeet.ManageWise.persistence.entity.BusinessEntity
import com.inderjeet.ManageWise.persistence.entity.helper.AccessLevel
import com.inderjeet.ManageWise.persistence.entity.userToBusiness.UserToBusinessAccessEntity
import com.inderjeet.ManageWise.persistence.entity.userToBusiness.UserToBusinessEntity
import com.inderjeet.ManageWise.persistence.repository.BusinessJpaRepository
import com.inderjeet.ManageWise.persistence.repository.UserJpaRepository
import com.inderjeet.ManageWise.persistence.repository.UserToBusinessAccessRepository
import com.inderjeet.ManageWise.persistence.repository.UserToBusinessRepository
import com.inderjeet.ManageWise.rest.exceptionHandler.ServerError
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BusinessServiceImpl(
    val userJpaRepository: UserJpaRepository,
    val businessRepository: BusinessJpaRepository,
    val userToBusinessRepository: UserToBusinessRepository,
    val userToBusinessAccessRepository: UserToBusinessAccessRepository
) : BusinessService {

    @Transactional
    override fun createBusiness(createBusinessDTO: CreateBusinessDTO, userHash: String) {
        try {
            val businessEntity = BusinessEntity(userHash, createBusinessDTO)
            val business = businessRepository.save(businessEntity)
            val user = userJpaRepository.findById(userHash)
            user.get().let {
                val userToBusinessEntity = UserToBusinessEntity(user = it, business = business)
                userToBusinessRepository.save(userToBusinessEntity)

                val userToBusinessAccess =
                    UserToBusinessAccessEntity(user = it, business = business, accessLevel = AccessLevel.BUSINESS_OWNER)
                userToBusinessAccessRepository.save(userToBusinessAccess)
            }
        } catch (e: Exception) {
            throw ServerError("An unexpected error occurred: ${e.message}")
        }
    }

}