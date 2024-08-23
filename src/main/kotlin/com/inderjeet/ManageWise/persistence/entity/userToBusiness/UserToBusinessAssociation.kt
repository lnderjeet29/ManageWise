package com.inderjeet.ManageWise.persistence.entity.userToBusiness

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import java.io.Serializable
@Embeddable
data class UserToBusinessAssociation(

    @Column(name = "user_hash")
    var userHash: String,

    @Column(name = "business_hash")
    var businessHash : String

) : Serializable{
    constructor():this("","")
}
