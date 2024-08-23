package com.inderjeet.ManageWise.persistence.entity

import com.inderjeet.ManageWise.business.dto.userDto.CreateUserDto
import com.inderjeet.ManageWise.persistence.entity.userToBusiness.UserToBusinessEntity
import jakarta.persistence.*

@Entity
@Table(name = "UserEntity")
class UserEntity : BaseEntity {

    @Column(nullable = false)
    var firstName: String = ""

    @Column(nullable = false)
    var lastName: String = ""

    @Column(name = "email", nullable = false, unique = true)
    var email: String = ""

    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], orphanRemoval = true)
    var userToBusinesses: MutableList<UserToBusinessEntity> = mutableListOf()

    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], orphanRemoval = true)
    var clients: MutableList<com.inderjeet.ManageWise.persistence.entity.ClientEntity> = mutableListOf()

    override val prefix: String
        get() = ""

    constructor()
    constructor(createUserDto: CreateUserDto, userHash: String) : super(userHash) {
        this.hash = userHash
        this.email = createUserDto.email
        this.firstName = createUserDto.firstName
        this.lastName = createUserDto.lastName
    }
}
