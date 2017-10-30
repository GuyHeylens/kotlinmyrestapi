package be.kotlin.myrestapi.kotlinmyrestapi.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class BeerEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0,
        val beerName: String = "",
        val beerType: String = "",
        val alcoholPercentage: Double = 0.0,
        val beerColour: String = "")
