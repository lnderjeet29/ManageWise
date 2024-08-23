package com.inderjeet.ManageWise.persistence.entity

import com.inderjeet.ManageWise.persistence.entity.helper.InviteStatus
import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.*

@Entity
@Table(name = "ClientEntity")
class ClientEntity : com.inderjeet.ManageWise.persistence.entity.BaseEntity {
    @Column(nullable = false)
    var name: String = ""

    @Column(nullable = false)
    var invitationEmail: String = ""

    @Column(name = "user_hash")
    var userHash: String? = null

    @Column(name = "last_invite_sent_date")
    var lastInviteSentDate: LocalDateTime? = null

    @Enumerated(EnumType.STRING)
    @Column(name = "invite_status", nullable = false)
    var inviteStatus: InviteStatus = InviteStatus.NOT_SENT

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "business_hash", referencedColumnName = "hash", nullable = false)
    var business: com.inderjeet.ManageWise.persistence.entity.BusinessEntity? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_hash", referencedColumnName = "hash", insertable = false, updatable = false)
    var user: com.inderjeet.ManageWise.persistence.entity.UserEntity? = null

    override val prefix: String
        get() = "client_"

    fun getClientName(): String {
        return user?.let { "${it.firstName} ${it.lastName}" } ?: this.name
    }

    constructor() : super("")
    constructor(
        name: String,
        invitationEmail: String,
        userHash: String?,
        lastInviteSentDate: LocalDateTime?,
        inviteStatus: InviteStatus,
        business: com.inderjeet.ManageWise.persistence.entity.BusinessEntity?,
        user: com.inderjeet.ManageWise.persistence.entity.UserEntity?
    ) : super(UUID.randomUUID().toString()) {
        this.name = name
        this.invitationEmail = invitationEmail
        this.userHash = userHash
        this.lastInviteSentDate = lastInviteSentDate
        this.inviteStatus = inviteStatus
        this.business = business
        this.user = user
    }
}
