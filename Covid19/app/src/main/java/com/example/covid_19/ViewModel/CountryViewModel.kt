package com.example.covid_19.ViewModel

import com.google.gson.annotations.SerializedName

data class CountryViewModel(
    @SerializedName("Country") val country : String,
    @SerializedName("CountryCode") val countryCode : String,
    @SerializedName("NewConfirmed") val newConfirmed : Int,
    @SerializedName("TotalConfirmed") val totalConfirmed : Int,
    @SerializedName("NewDeaths") val newDeaths : Int,
    @SerializedName("TotalDeaths") val totalDeaths : Int,
    @SerializedName("NewRecovered") val newRecovered : Int,
    @SerializedName("TotalRecovered") val totalRecovered : Int
)