package be.kotlin.myrestapi.kotlinmyrestapi.controller

import be.kotlin.myrestapi.kotlinmyrestapi.data.*
import be.kotlin.myrestapi.kotlinmyrestapi.repository.BeerRepository
import be.kotlin.myrestapi.kotlinmyrestapi.repository.BeerTypeRepository
import be.kotlin.myrestapi.kotlinmyrestapi.repository.BreweryRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class BeerController(private val beerRepo: BeerRepository,
                     private val breweryRepository: BreweryRepository,
                     private val beerTypeRepository: BeerTypeRepository) {


    //region Create
    @PostMapping("/beers")
    fun createNewBeer(@Valid @RequestBody beerResource: BeerResource) {
        val beerTypeResult : BeerTypeDto = beerTypeRepository.getOne(beerResource.beerTypeId)
        val breweryResult = breweryRepository.getOne(beerResource.breweryId)
        val beer = BeerDto(beerResource.id, beerResource.beerName, beerResource.alcoholPercentage, beerResource.beerColour,
                beerType = beerTypeResult, brewery = breweryResult )
        beerRepo.save(beer)
    }
    //endregion

    //region Read
    @GetMapping("/beers")
    fun getBeers(): List<BeerResource> {
        return beerRepo.findAll().map {
            beerDto -> BeerResource(beerDto.id, beerDto.beerName, beerDto.alcoholPercentage, beerDto.beerColour,
                beerDto.beerType.id, beerDto.beerType.beerType,
                beerDto.beerType.beerJudgeCertification , beerDto.brewery.id, beerDto.brewery.breweryName)
        }
    }


    @GetMapping("/beer/{id}")
    fun getBeerById(@PathVariable id: Long): ResponseEntity<BeerDto> {
        return beerRepo.findById(id).map {
            ResponseEntity.ok(it)
        }.orElseGet({ResponseEntity.notFound().build()})
    }






    //endregion


    //region Update
    @PutMapping("/beer/{id}")
    fun updateBeer(@PathVariable id:Long, @Valid @RequestBody newBeerDto: BeerDto): ResponseEntity<BeerDto>{

        var existing = beerRepo.getOne(id)

        val updatedBeer = existing.copy(beerName = newBeerDto.beerName, beerColour = newBeerDto.beerColour, alcoholPercentage = newBeerDto.alcoholPercentage)

        val result = beerRepo.save(updatedBeer)

        return if(result != null ){
            ResponseEntity.ok(result)
        } else {
            ResponseEntity.notFound().build()
        }

    }
    //endregion






}