package be.kotlin.myrestapi.kotlinmyrestapi.entity

import javax.persistence.*

@Entity
data class BeerEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0,
        val beerName: String = "",
        val alcoholPercentage: Double = 0.0,
        val beerColour: String = "",
        @OneToOne
        val beerType: BeerTypeEntity = BeerTypeEntity(),
        @ManyToOne
        val brewery: BreweryEntity = BreweryEntity())
