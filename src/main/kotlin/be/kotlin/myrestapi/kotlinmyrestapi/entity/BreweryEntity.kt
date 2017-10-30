package be.kotlin.myrestapi.kotlinmyrestapi.entity

import javax.persistence.*

@Entity
data class BreweryEntity(
        @Id @GeneratedValue(strategy=GenerationType.AUTO)
        val Id: Long = 0,
        val BreweryName : String = "",
        val StreetName: String = "",
        val HouseNumber: String = "",
        val PostalCode: String = "",
        val Town: String = ""
)