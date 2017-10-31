package be.kotlin.myrestapi.kotlinmyrestapi.controller

import be.kotlin.myrestapi.kotlinmyrestapi.entity.BeerEntity
import be.kotlin.myrestapi.kotlinmyrestapi.repository.BeerRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class BeerController(private val beerRepo: BeerRepository) {

    @GetMapping("/beers")
    fun getBeers(): List<BeerEntity> {
        return beerRepo.findAll()
    }


    @PostMapping("/beers")
    fun createNewBeer(@Valid @RequestBody beerEntity: BeerEntity): BeerEntity {
        val result = beerRepo.save(beerEntity)
        return result
    }

    @GetMapping("/beers/{id}")
    fun getBeerById(@PathVariable(value = "id") Id: Long): ResponseEntity<BeerEntity>{
        var result = beerRepo.getOne(Id)
        return if(result != null) {
            ResponseEntity.ok(result)
        } else {
            ResponseEntity.notFound().build()
        }
    }


    @PutMapping("/beers/{id}")
    fun updateBeer(@PathVariable(value = "id") Id:Long, @Valid @RequestBody newBeerEntity: BeerEntity): ResponseEntity<BeerEntity>{

        var existing = beerRepo.getOne(Id)

        val updatedBeer = existing.copy(beerName = newBeerEntity.beerName, beerColour = newBeerEntity.beerColour, alcoholPercentage = newBeerEntity.alcoholPercentage, beerType = newBeerEntity.beerType)

        val result = beerRepo.save(updatedBeer)

        return if(result != null ){
            ResponseEntity.ok(result)
        } else {
            ResponseEntity.notFound().build()
        }

    }



}