package be.kotlin.myrestapi.kotlinmyrestapi.repository

import be.kotlin.myrestapi.kotlinmyrestapi.entity.BreweryEntity
import org.springframework.data.jpa.repository.JpaRepository

interface BreweryRepository : JpaRepository<BreweryEntity, Long>{
    fun findByBreweryName(breweryName: String): Iterable<BreweryEntity>
    fun findByCountryName(countryName: String): Iterable<BreweryEntity>
}