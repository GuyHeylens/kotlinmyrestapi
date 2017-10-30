package be.kotlin.myrestapi.kotlinmyrestapi.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class BeerTypeEntity(
        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        val Id: Long = 0,
        val BeerType: String = "",
        val BeerJudgeCertification: String = ""
)