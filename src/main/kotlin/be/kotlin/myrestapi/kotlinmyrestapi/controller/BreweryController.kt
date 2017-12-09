package be.kotlin.myrestapi.kotlinmyrestapi.controller

import be.kotlin.myrestapi.kotlinmyrestapi.data.BeerResource
import be.kotlin.myrestapi.kotlinmyrestapi.data.BreweryBeerResource
import be.kotlin.myrestapi.kotlinmyrestapi.data.BreweryDto
import be.kotlin.myrestapi.kotlinmyrestapi.data.BreweryResource
import be.kotlin.myrestapi.kotlinmyrestapi.repository.BeerRepository
import be.kotlin.myrestapi.kotlinmyrestapi.repository.BreweryRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class BreweryController(private val breweryRepository: BreweryRepository, private val beerRepository: BeerRepository) {

    @GetMapping("/breweries")
    fun getBreweries(): List<BreweryResource> {
        return breweryRepository.findAll().map { breweryDto -> BreweryResource(breweryDto.id, breweryDto.breweryName,
                breweryDto.streetName, breweryDto.houseNumber, breweryDto.postalCode, breweryDto.town,
                breweryDto.country.id, breweryDto.country.countryName) }
    }

    @GetMapping("brewery/{id}")
    fun getBreweryById(@PathVariable(value = "id") Id: Long): ResponseEntity<BreweryResource> {
        val result =  breweryRepository.getOne(Id)
        return if(result != null) {
            ResponseEntity.ok(BreweryResource(result.id, result.breweryName, result.streetName, result.houseNumber,
                    result.postalCode, result.town, result.country.id, result.country.countryName))
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @GetMapping("breweries/name/{name}")
    fun getBreweryByName(@PathVariable(value = "name") breweryName: String): ResponseEntity<List<BreweryResource>>? {
        val b = breweryRepository.findByBreweryName(breweryName).map { breweryDto -> BreweryResource(breweryDto.id, breweryDto.breweryName, breweryDto.streetName,
                breweryDto.houseNumber, breweryDto.postalCode, breweryDto.town,
                breweryDto.country.id, breweryDto.country.countryName) }

        return if(b.isNotEmpty()){
            ResponseEntity.ok(b)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @GetMapping("brewery/{id}/beers")
    fun getBeersByBreweryId(@PathVariable id: Long): ResponseEntity<BreweryBeerResource>? {

        val result =  breweryRepository.getOne(id)
        return if(result != null) {

            val breweryResource = BreweryResource(result.id, result.breweryName, result.streetName, result.houseNumber, result.postalCode, result.town, result.country.id , result.country.countryName)

            val beers = beerRepository.findByBreweryId(id)?.map { beerDto -> BeerResource(beerDto.id, beerDto.beerName, beerDto.alcoholPercentage, beerDto.beerColour, beerDto.beerType.id, beerDto.beerType.beerType, beerDto.beerType.beerJudgeCertification, beerDto.brewery.id, beerDto.brewery.breweryName) }

            ResponseEntity.ok(BreweryBeerResource(breweryResource, beers))
        } else {
            ResponseEntity.notFound().build()
        }
    }


}