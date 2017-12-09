package be.kotlin.myrestapi.kotlinmyrestapi.controller

import be.kotlin.myrestapi.kotlinmyrestapi.data.BeerTypeDto
import be.kotlin.myrestapi.kotlinmyrestapi.data.BeerTypeResource
import be.kotlin.myrestapi.kotlinmyrestapi.repository.BeerRepository
import be.kotlin.myrestapi.kotlinmyrestapi.repository.BeerTypeRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class BeerTypeController(private val beerTypeRepository: BeerTypeRepository, private  val beerRepo: BeerRepository) {

    @GetMapping("/beertypes")
    fun getBeerTypes(): List<BeerTypeResource>{
        return beerTypeRepository.findAll().map { beerTypeDto -> BeerTypeResource(beerTypeDto.id, beerTypeDto.beerType, beerTypeDto.beerJudgeCertification) }
    }

    @GetMapping("/beertypes/{beertypename}")
    fun getBeerTypeByName(@PathVariable(value = "beertypename") beerTypeName: String): ResponseEntity<List<BeerTypeResource>>{

        val result = beerTypeRepository.findByBeerType(beerTypeName).map {
            beerTypeDto -> BeerTypeResource(beerTypeDto.id, beerTypeDto.beerType, beerTypeDto.beerJudgeCertification)
        }

        return  if(result.isNotEmpty()){
            ResponseEntity.ok(result)
        } else {
            ResponseEntity.notFound().build()
        }

    }

    @GetMapping("/type/{id}/beers")
    fun getBeersByTypeId(@PathVariable id: Long)= beerRepo.findByBeerTypeId(id).let{
        ResponseEntity.ok(it)
    }?: ResponseEntity.notFound().build()
}