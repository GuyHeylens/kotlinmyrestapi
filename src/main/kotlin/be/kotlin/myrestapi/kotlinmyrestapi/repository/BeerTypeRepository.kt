package be.kotlin.myrestapi.kotlinmyrestapi.repository

import be.kotlin.myrestapi.kotlinmyrestapi.data.BeerTypeDto
import org.springframework.data.jpa.repository.JpaRepository

interface BeerTypeRepository : JpaRepository<BeerTypeDto, Long>{
    fun findByBeerType(beerTypeName: String): Iterable<BeerTypeDto>

    fun findByBeerJudgeCertification(beerTypeJudgeCertification: String): Iterable<BeerTypeDto>
}