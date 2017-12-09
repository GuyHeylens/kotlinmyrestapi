package be.kotlin.myrestapi.kotlinmyrestapi.repository

import be.kotlin.myrestapi.kotlinmyrestapi.data.BeerDto
import be.kotlin.myrestapi.kotlinmyrestapi.data.BreweryDto
import org.springframework.data.jpa.repository.JpaRepository

interface BeerRepository : JpaRepository<BeerDto, Long>{

    fun findByBeerName(beerName: String):Iterable<BeerDto>

    fun findByAlcoholPercentage(percentage: Double):Iterable<BeerDto>

    fun findByBeerTypeId(beerTypeId: Long): Iterable<BeerDto>?

    fun findByBreweryId(breweryId: Long): Iterable<BeerDto>?

}