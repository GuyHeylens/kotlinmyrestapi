package be.kotlin.myrestapi.kotlinmyrestapi.entity

import javax.persistence.*

@Entity
data class CountryEntity (
        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        val id: Long = 0,
        val countryName: String = ""

)