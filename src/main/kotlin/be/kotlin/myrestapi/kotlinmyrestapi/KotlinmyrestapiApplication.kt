package be.kotlin.myrestapi.kotlinmyrestapi

import be.kotlin.myrestapi.kotlinmyrestapi.entity.BeerEntity
import be.kotlin.myrestapi.kotlinmyrestapi.entity.BeerTypeEntity
import be.kotlin.myrestapi.kotlinmyrestapi.entity.BreweryEntity
import be.kotlin.myrestapi.kotlinmyrestapi.entity.CountryEntity
import be.kotlin.myrestapi.kotlinmyrestapi.repository.BeerRepository
import be.kotlin.myrestapi.kotlinmyrestapi.repository.BeerTypeRepository
import be.kotlin.myrestapi.kotlinmyrestapi.repository.BreweryRepository
import be.kotlin.myrestapi.kotlinmyrestapi.repository.CountryRepository
import org.h2.server.web.WebServlet
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.web.servlet.ServletRegistrationBean
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
        repoCountry.save(CountryEntity(1, "Belgium"))

        //save BeerTypes

        repoBeerType.save(BeerTypeEntity(1, "Blonde Ale", "Blonde Ale" ))
        repoBeerType.save(BeerTypeEntity(2, "Flanders Red Ale", "Flanders Red Ale" ))
        repoBeerType.save(BeerTypeEntity(3, "Geuze", "Geuze" ))
        repoBeerType.save(BeerTypeEntity(4, "Lambic", "Lambic" ))
        repoBeerType.save(BeerTypeEntity(5, "Oud Bruin", "Oud Bruin" ))

        //save Brewery
        repoBrewery.save(BreweryEntity(1, "Abdij Westvleteren", "Donkerstraat", "12", "8640", "Vleteren", countryId = 1))

        //save some beers
        repoBeer.save(BeerEntity(1,"Westvleteren Blond",  5.8, "Blond", 1, 1))
        repoBeer.save(BeerEntity(2,"Westvleteren Acht",  8.0, "Brown", 5, 1))
        repoBeer.save(BeerEntity(3,"Westvleteren Twaalf", 10.8, "Brown", 5, 1))






    }


}


fun main(args: Array<String>) {
    SpringApplication.run(KotlinmyrestapiApplication::class.java, *args)
}
