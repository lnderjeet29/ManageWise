package com.inderjeet.ManageWise.persistence.entity.userToBusiness

import com.inderjeet.ManageWise.persistence.entity.BaseEntity
import com.inderjeet.ManageWise.persistence.entity.BusinessEntity
import com.inderjeet.ManageWise.persistence.entity.UserEntity
import jakarta.persistence.*

@Entity
@Table(name = "UserToBusiness")
class UserToBusinessEntity : BaseEntity {
    @Embedded
    var id: UserToBusinessAssociation = UserToBusinessAssociation()

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userHash")
    @JoinColumn(name = "user_hash", referencedColumnName = "hash", insertable = false, updatable = false)
    var user: UserEntity? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("businessHash")
    @JoinColumn(name = "business_hash", referencedColumnName = "hash", insertable = false, updatable = false)
    var business: BusinessEntity? = null

    override val prefix: String
        get() = "utb"

    constructor()
    constructor(user: UserEntity, business: BusinessEntity) : super(user.hash) {
        this.id.userHash = user.hash
        this.id.businessHash = business.hash
    }
}