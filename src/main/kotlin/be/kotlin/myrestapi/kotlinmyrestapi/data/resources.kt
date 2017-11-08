package be.kotlin.myrestapi.kotlinmyrestapi.data

data class BeerResource(val id: Long?, val beerName: String?, val alcoholPercentage: Double?, val beerColour: String?, val beerType: BeerTypeDto?, val brewery: BreweryDto?)

data class BeerTypeResource(val id: Long?, val beerTypeName: String?, val beerJudgeCertification: String?)

data class BreweryResource(val id: Long?, val breweryName:String?)

data class CountryResource(val id: Long?, val countryName: String?)