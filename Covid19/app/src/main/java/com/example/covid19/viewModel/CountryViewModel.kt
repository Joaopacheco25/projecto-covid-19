package com.example.covid19.viewModel


data class CountryViewModel(
    val country : String,
    val newConfirmed : Int,
    val countryCode : String? = null,
    val totalConfirmed : Int? = null,
    val newDeaths : Int? = null,
    val totalDeaths : Int?= null,
    val newRecovered : Int?= null,
    val totalRecovered : Int?= null
)