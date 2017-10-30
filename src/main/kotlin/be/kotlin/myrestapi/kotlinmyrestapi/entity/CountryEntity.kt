package be.kotlin.myrestapi.kotlinmyrestapi.entity

import javax.persistence.*

@Entity
data class CountryEntity (
        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        val Id : Long = 0,
        val CountryName: String = ""

)