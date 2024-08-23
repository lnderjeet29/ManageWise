package com.inderjeet.ManageWise.business.dto.clientDto

data class CreateClientRequestDto(
    var name: String,
    var userHash: String? = null,
    var businessHash: String,
)



