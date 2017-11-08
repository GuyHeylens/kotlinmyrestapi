package be.kotlin.myrestapi.kotlinmyrestapi

import be.kotlin.myrestapi.kotlinmyrestapi.data.BeerDto
import be.kotlin.myrestapi.kotlinmyrestapi.data.BeerTypeDto
import be.kotlin.myrestapi.kotlinmyrestapi.data.BreweryDto
import be.kotlin.myrestapi.kotlinmyrestapi.data.CountryDto
import be.kotlin.myrestapi.kotlinmyrestapi.repository.BeerRepository
import be.kotlin.myrestapi.kotlinmyrestapi.repository.BeerTypeRepository
import be.kotlin.myrestapi.kotlinmyrestapi.repository.BreweryRepository
import be.kotlin.myrestapi.kotlinmyrestapi.repository.CountryRepository
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean


@SpringBootApplication
class KotlinmyrestapiApplication{

    private val log = LoggerFactory.getLogger(KotlinmyrestapiApplication::class.java)


//    @Bean
//    fun h2servletRegistration(): ServletRegistrationBean {
//        val registration = ServletRegistrationBean(WebServlet())
//        registration.addUrlMappings("/console/*")
//        return registration
//    }


    @Bean
    fun init(repoBeer: BeerRepository, repoBeerType: BeerTypeRepository, repoCountry: CountryRepository, repoBrewery: BreweryRepository) = CommandLineRunner{

        //save Country

        val c =repoCountry.save(CountryDto(1, "Belgium"))

        //save BeerTypes
        val typeBlond = repoBeerType.save(BeerTypeDto(1, "Blonde Ale", "Blonde Ale" ))

        repoBeerType.save(BeerTypeDto(2, "Flanders Red Ale", "Flanders Red Ale" ))
        repoBeerType.save(BeerTypeDto(3, "Geuze", "Geuze" ))
        repoBeerType.save(BeerTypeDto(4, "Lambic", "Lambic" ))
        val typeBrown = repoBeerType.save(BeerTypeDto(5, "Oud Bruin", "Oud Bruin" ))


        //save Brewery
        val brewery = repoBrewery.save(BreweryDto(1, "Abdij Westvleteren", "Donkerstraat", "12", "8640", "Vleteren",  country = c))

        //save some beers
        repoBeer.save(BeerDto(1,"Westvleteren Blond",  5.8, "Blond", typeBlond, brewery))
        repoBeer.save(BeerDto(2,"Westvleteren Acht",  8.0, "Brown", typeBrown, brewery))
        repoBeer.save(BeerDto(3,"Westvleteren Twaalf", 10.8, "Brown", typeBrown, brewery))

    }
}


fun main(args: Array<String>) {
    SpringApplication.run(KotlinmyrestapiApplication::class.java, *args)
}
