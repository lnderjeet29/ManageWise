package com.inderjeet.ManageWise.persistence.entity.userToBusiness

import com.inderjeet.ManageWise.persistence.entity.BaseEntity
import com.inderjeet.ManageWise.persistence.entity.BusinessEntity
import com.inderjeet.ManageWise.persistence.entity.UserEntity
import com.inderjeet.ManageWise.persistence.entity.helper.AccessLevel
import jakarta.persistence.*

@Entity
@Table(name = "UserToBusinessAccessEntity")
class UserToBusinessAccessEntity : BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    var accessLevel: AccessLevel = AccessLevel.BUSINESS_OWNER

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_hash", referencedColumnName = "hash")
    var user: UserEntity? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "business_hash", referencedColumnName = "hash")
    var business: BusinessEntity? = null

    override val prefix: String
        get() = "utba"

    constructor()
    constructor(user: UserEntity, business: BusinessEntity, accessLevel: AccessLevel) : super(user.hash) {
        this.accessLevel = accessLevel
        this.user = user
        this.business = business
    }
}