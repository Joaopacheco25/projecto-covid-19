package com.example.covid_19.Entity

import java.util.*

data class Countries(
    val Country:String,
    val NewConfirmed :Int,
    val TotalConfirmed: Int,
    val NewDeaths:Int,
    val TotalDeaths:Int,
    val TotalRecovered:Int,
    val NewRecovered:Int,
    val Date:Date
)