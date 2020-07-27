package com.example.covid19.entity

import java.util.*
import kotlin.collections.ArrayList

class Country : ArrayList<CountryItem>()

data class CountryItem(
    val Active: Int,
    val City: String,
    val CityCode: String,
    val Confirmed: Int,
    val Country: String,
    val CountryCode: String,
    val Date: Date,
    val Deaths: Int,
    val Lat: String,
    val Lon: String,
    val Province: String,
    val Recovered: Int
)