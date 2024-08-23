package com.inderjeet.ManageWise.business.gateway

import com.inderjeet.ManageWise.business.dto.businessDto.CreateBusinessDTO

interface BusinessService {
    fun createBusiness(createBusinessDTO:CreateBusinessDTO, userHash: String)
}