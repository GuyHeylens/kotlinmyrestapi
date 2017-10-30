package be.kotlin.myrestapi.kotlinmyrestapi.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class BeerEntity (
        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        val Id: Long = 0,

        val BeerName: String = "", val BeerType: String = "", val AlcoholPerc: Double = 0.0, val BeerColour: String = "")
