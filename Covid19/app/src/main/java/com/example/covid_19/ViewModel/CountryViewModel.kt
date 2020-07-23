package com.example.covid_19.ViewModel

import com.google.gson.annotations.SerializedName

data class CountryViewModel(
    @SerializedName("Country") val country : String,
    @SerializedName("NewConfirmed") val newConfirmed : Int,
    @SerializedName("CountryCode") val countryCode : String? = null,
    @SerializedName("TotalConfirmed") val totalConfirmed : Int? = null,
    @SerializedName("NewDeaths") val newDeaths : Int? = null,
    @SerializedName("TotalDeaths") val totalDeaths : Int?= null,
    @SerializedName("NewRecovered") val newRecovered : Int?= null,
    @SerializedName("TotalRecovered") val totalRecovered : Int?= null
)