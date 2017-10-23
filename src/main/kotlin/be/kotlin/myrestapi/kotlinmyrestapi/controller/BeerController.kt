package be.kotlin.myrestapi.kotlinmyrestapi.controller

import be.kotlin.myrestapi.kotlinmyrestapi.entity.BeerEntity
import be.kotlin.myrestapi.kotlinmyrestapi.repository.BeerRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class BeerController(private val beerRepo: BeerRepository) {

    @GetMapping("/beer")
    fun getBeers(): List<BeerEntity> = beerRepo.findAll() as List<BeerEntity>


    @PostMapping("/beer")
    fun createNewBeer(@Valid @RequestBody beerEntity: BeerEntity): BeerEntity = beerRepo.save(beerEntity)

    @GetMapping("/beer/{id}")
    fun getBeerById(@PathVariable(value = "id") Id: Long): ResponseEntity<BeerEntity>{
        var result = beerRepo.findOne(Id)
        return if(result != null) {
            ResponseEntity.ok(result)
        } else {
            ResponseEntity.notFound().build()
        }
    }


    @PutMapping("/beer/{id}")
    fun updateBeer(@PathVariable(value = "id") Id:Long, @Valid @RequestBody newBeerEntity: BeerEntity): ResponseEntity<BeerEntity>{

        var existing = beerRepo.findOne(Id)

        val updatedBeer = existing.copy(BeerName = newBeerEntity.BeerName, BeerColour = newBeerEntity.BeerColour, AlcoholPerc = newBeerEntity.AlcoholPerc, BeerType = newBeerEntity.BeerType)

        val result = beerRepo.save(updatedBeer)

        return if(result != null ){
            ResponseEntity.ok(result)
        } else {
            ResponseEntity.notFound().build()
        }

    }



}