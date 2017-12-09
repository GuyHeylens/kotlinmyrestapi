package be.kotlin.myrestapi.kotlinmyrestapi.data


//Resource representation classes
//Exposed to the outside

data class BeerResource(val id: Long, val beerName: String, val alcoholPercentage: Double, val beerColour: String,
                        val beerTypeId: Long, val beerType: String, val beerJudge :String, val breweryId: Long,
                        val breweryName: String)

data class BeerTypeResource(val id: Long, val beerTypeName: String, val beerJudgeCertification: String)

data class BreweryResource(val id: Long, val breweryName:String, val streetName: String, val houseNr: String,
                           val postalCode: String, val town: String, val countryId :Long,  val countryName: String)

data class BreweryBeerResource(val brewery: BreweryResource, val beers: List<BeerResource>?)

data class CountryResource(val id: Long, val countryName: String)