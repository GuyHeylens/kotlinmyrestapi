package be.kotlin.myrestapi.kotlinmyrestapi.controller

import be.kotlin.myrestapi.kotlinmyrestapi.data.CountryDto
import be.kotlin.myrestapi.kotlinmyrestapi.data.CountryResource
import be.kotlin.myrestapi.kotlinmyrestapi.repository.CountryRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import sun.reflect.generics.tree.ReturnType
import sun.security.provider.certpath.OCSPResponse

@RestController
@RequestMapping("/api")
class CountryController(private val countryRepository: CountryRepository) {

    @GetMapping("/countries")
    fun getCountries():List<CountryResource> =
            countryRepository.findAll().map { countryDto -> CountryResource(countryDto.id, countryDto.countryName) }




    @GetMapping("/country/{countryName}")
    fun getCountryByName(@PathVariable(value = "countryName") countryName: String): ResponseEntity<CountryResource>?
    {
        var c = countryRepository.findByCountryName(countryName)

        return if (c != null) {
            ResponseEntity.ok(CountryResource(c.id, c.countryName))
        } else {
            ResponseEntity.notFound().build<CountryResource>()
        }
    }




}