package be.kotlin.myrestapi.kotlinmyrestapi.repository

import be.kotlin.myrestapi.kotlinmyrestapi.entity.CountryEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CountryRepository : JpaRepository<CountryEntity, Long>