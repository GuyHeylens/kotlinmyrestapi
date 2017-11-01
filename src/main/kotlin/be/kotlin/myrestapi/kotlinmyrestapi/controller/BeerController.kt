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
    fun createNewBeer(@Valid @RequestBody beerEntity: BeerEntity) = beerRepo.save(beerEntity)

    @GetMapping("/beers/{id}")
    fun getBeerById(@PathVariable(value = "id") Id: Long)= beerRepo.getOne(Id)?.let {
        ResponseEntity.ok(it)
    } ?: ResponseEntity.notFound().build()

    @GetMapping("/beers/type/{id}")
    fun getBeersByTypeId(@PathVariable(value = "id") Id: Long)= beerRepo.findByBeerTypeId(Id)?.let{
        ResponseEntity.ok(it)
    }?: ResponseEntity.notFound().build()


    @PutMapping("/beers/{id}")
    fun updateBeer(@PathVariable(value = "id") Id:Long, @Valid @RequestBody newBeerEntity: BeerEntity): ResponseEntity<BeerEntity>{

        var existing = beerRepo.getOne(Id)

        val updatedBeer = existing.copy(beerName = newBeerEntity.beerName, beerColour = newBeerEntity.beerColour, alcoholPercentage = newBeerEntity.alcoholPercentage)

        val result = beerRepo.save(updatedBeer)

        return if(result != null ){
            ResponseEntity.ok(result)
        } else {
            ResponseEntity.notFound().build()
        }

    }

}