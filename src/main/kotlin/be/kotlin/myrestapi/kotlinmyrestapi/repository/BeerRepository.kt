package be.kotlin.myrestapi.kotlinmyrestapi.repository

import be.kotlin.myrestapi.kotlinmyrestapi.entity.BeerEntity
import org.springframework.data.jpa.repository.JpaRepository

interface BeerRepository : JpaRepository<BeerEntity, Long>