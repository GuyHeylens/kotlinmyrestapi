package be.kotlin.myrestapi.kotlinmyrestapi.repository

import be.kotlin.myrestapi.kotlinmyrestapi.data.CountryDto
import org.springframework.data.jpa.repository.JpaRepository

interface CountryRepository : JpaRepository<CountryDto, Long>{

    fun findByCountryName(countryName: String): CountryDto?
}