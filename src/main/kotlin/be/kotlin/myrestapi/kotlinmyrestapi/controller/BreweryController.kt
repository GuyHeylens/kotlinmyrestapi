package be.kotlin.myrestapi.kotlinmyrestapi.controller

import be.kotlin.myrestapi.kotlinmyrestapi.data.BreweryDto
import be.kotlin.myrestapi.kotlinmyrestapi.repository.BreweryRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class BreweryController(private val breweryRepository: BreweryRepository) {

    @GetMapping("/breweries")
    fun getBreweries():List<BreweryDto> {
        return breweryRepository.findAll()
    }

    @GetMapping("breweries/{id}")
    fun getBreweryById(@PathVariable(value = "id") Id: Long): ResponseEntity<BreweryDto> {
        val result =  breweryRepository.getOne(Id)
        return if(result != null) {
            ResponseEntity.ok(result)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @GetMapping("breweries/name/{name}")
    fun getBreweryByName(@PathVariable(value = "name") breweryName: String):List<BreweryDto>{
        return breweryRepository.findByBreweryName(breweryName) as List<BreweryDto>
    }
}