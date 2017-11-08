package be.kotlin.myrestapi.kotlinmyrestapi.controller

import be.kotlin.myrestapi.kotlinmyrestapi.data.BeerDto
import be.kotlin.myrestapi.kotlinmyrestapi.repository.BeerRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class BeerController(private val beerRepo: BeerRepository) {

    @GetMapping("/beers")
    fun getBeers(): List<BeerDto> {
        return beerRepo.findAll()
    }

    @PostMapping("/beers")
    fun createNewBeer(@Valid @RequestBody beerDto: BeerDto) = beerRepo.save(beerDto)

    /*
    @GetMapping("/beers/{id}")
    fun getBeerById(@PathVariable(value = "id") Id: Long)= beerRepo.getOne(Id).let {
        ResponseEntity.ok(it)
    } ?: ResponseEntity.notFound().build()*/



    @GetMapping("/beers/{id}")
    fun getBeerById(@PathVariable id: Long): ResponseEntity<BeerDto> {
        return beerRepo.findById(id).map {
            ResponseEntity.ok(it)
        }.orElseGet({ResponseEntity.notFound().build()})
    }

    @GetMapping("/beers/type/{id}")
    fun getBeersByTypeId(@PathVariable id: Long)= beerRepo.findByBeerTypeId(id).let{
        ResponseEntity.ok(it)
    }?: ResponseEntity.notFound().build()


    @PutMapping("/beers/{id}")
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

}