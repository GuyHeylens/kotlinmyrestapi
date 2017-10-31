package be.kotlin.myrestapi.kotlinmyrestapi.entity

import javax.persistence.*

@Entity
data class BreweryEntity(
        @Id @GeneratedValue(strategy=GenerationType.AUTO)
        val id: Long = 0,
        val breweryName: String = "",
        val streetName: String = "",
        val houseNumber: String = "",
        val postalCode: String = "",
        val town: String = ""
)