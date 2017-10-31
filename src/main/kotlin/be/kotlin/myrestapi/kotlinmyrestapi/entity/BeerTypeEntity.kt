package be.kotlin.myrestapi.kotlinmyrestapi.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class BeerTypeEntity(
        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        val id: Long = 0,
        val beerType: String = "",
        val beerJudgeCertification: String = ""
)