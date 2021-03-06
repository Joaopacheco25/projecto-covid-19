package com.example.covid19.entity

import java.util.*
import kotlin.collections.ArrayList


data class Covid(
    val Global: Global,
    val Countries :ArrayList<Countries>
)


data class Global(
    val NewConfirmed:Int,
    val TotalConfirmed:Int,
    val NewDeaths:Int,
    val TotalDeaths:Int,
    val NewRecovered:Int,
    val TotalRecovered:Int
)

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

