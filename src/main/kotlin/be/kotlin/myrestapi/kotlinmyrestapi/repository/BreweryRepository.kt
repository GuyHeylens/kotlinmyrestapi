package be.kotlin.myrestapi.kotlinmyrestapi.repository

import be.kotlin.myrestapi.kotlinmyrestapi.data.BreweryDto
import org.springframework.data.jpa.repository.JpaRepository

interface BreweryRepository : JpaRepository<BreweryDto, Long>{
    fun findByBreweryName(breweryName: String): Iterable<BreweryDto>
}