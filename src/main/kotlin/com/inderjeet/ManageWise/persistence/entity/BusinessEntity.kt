package com.inderjeet.ManageWise.persistence.entity

import com.inderjeet.ManageWise.business.dto.businessDto.CreateBusinessDTO
import com.inderjeet.ManageWise.persistence.entity.userToBusiness.UserToBusinessEntity
import jakarta.persistence.*

@Entity
@Table(name = "BusinessEntity")
class BusinessEntity : BaseEntity {

    @Column(nullable = false)
    var name: String = ""

    override val prefix: String
        get() = "bus_"

    @OneToMany(mappedBy = "business", cascade = [CascadeType.ALL], orphanRemoval = true)
    var userToBusinesses: MutableList<UserToBusinessEntity> = mutableListOf()

    @OneToMany(mappedBy = "business", cascade = [CascadeType.ALL], orphanRemoval = true)
    var clients: MutableList<com.inderjeet.ManageWise.persistence.entity.ClientEntity> = mutableListOf()

    constructor():super("")

    constructor(userHash:String, createBusinessDTO: CreateBusinessDTO) : super(userHash) {
        this.name=createBusinessDTO.name
    }
}
