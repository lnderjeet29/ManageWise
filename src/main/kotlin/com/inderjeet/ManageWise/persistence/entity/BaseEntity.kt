package com.inderjeet.ManageWise.persistence.entity

import jakarta.persistence.Column
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass
import jakarta.persistence.Transient
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.util.*

@MappedSuperclass
abstract class BaseEntity {

    @Id
    @Column(name = "hash", nullable = false)
    var hash: String = ""

    @Column(name = "created_date", nullable = false, updatable = false)
    var createdDate: LocalDateTime = LocalDateTime.now(ZoneOffset.UTC)

    @Column(name = "created_by", nullable = false)
    var createdBy: String = ""

    @Column(name = "updated_date")
    var updatedDate: LocalDateTime = LocalDateTime.now(ZoneOffset.UTC)

    @Column(name = "updated_by")
    var updatedBy: String = ""

    @get:Transient
    abstract val prefix: String

    constructor()
    constructor(userHash: String) {
        this.hash = "${this.prefix}${UUID.randomUUID()}"
        this.createdBy = userHash
        this.updatedBy = userHash
        this.createdDate = LocalDateTime.now(ZoneOffset.UTC)
        this.updatedDate = LocalDateTime.now(ZoneOffset.UTC)
    }
}
