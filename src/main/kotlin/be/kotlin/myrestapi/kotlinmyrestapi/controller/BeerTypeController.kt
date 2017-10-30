package be.kotlin.myrestapi.kotlinmyrestapi.controller

import be.kotlin.myrestapi.kotlinmyrestapi.entity.BeerTypeEntity
import be.kotlin.myrestapi.kotlinmyrestapi.repository.BeerTypeRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class BeerTypeController(private val beerTypeRepository: BeerTypeRepository) {

    @GetMapping("/beertypes")
    fun getBeerTypes(): List<BeerTypeEntity>{
        return beerTypeRepository.findAll()
    }

    @GetMapping("/beertypes/{beertypename}")
    fun getBeerTypeByName(@PathVariable(value = "beertypename") beerTypeName: String):List<BeerTypeEntity>{
        return beerTypeRepository.findBeerTypeByName(beerTypeName) as List<BeerTypeEntity>
    }
}