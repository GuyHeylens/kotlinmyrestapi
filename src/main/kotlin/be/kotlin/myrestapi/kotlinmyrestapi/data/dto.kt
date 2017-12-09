package be.kotlin.myrestapi.kotlinmyrestapi.data

import java.util.*
import javax.persistence.*


//Database Table representation classes.

@Entity
data class BeerDto(
        @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = -1,
        val beerName: String = "",
        val alcoholPercentage: Double = 0.0,
        val beerColour: String = "",
        @OneToOne
        val beerType:  BeerTypeDto = BeerTypeDto(),
        @ManyToOne
        @JoinColumn(name="breweryId")
        val brewery: BreweryDto = BreweryDto())

@Entity
data class BeerTypeDto(
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    val id: Long = 0,
    val beerType: String = "",
    val beerJudgeCertification: String = "")

@Entity
data class BreweryDto(
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    val id: Long = 0,
    val breweryName: String = "",
    val streetName: String = "",
    val houseNumber: String = "",
    val postalCode: String = "",
    val town: String = "",
    @OneToOne
    val country: CountryDto = CountryDto(),
    @OneToMany
    val beers: List<BeerDto> = emptyList())

@Entity
data class CountryDto(
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    val id: Long = 0,
    val countryName: String = "")