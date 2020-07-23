package com.example.covid19.constants

interface Constant  {
    companion object {
        const val BASE_URL= "https://api.covid19api.com"
        const val SUMMARY_URL = "https://api.covid19api.com/summary"
        const val URL_BY_COUNTRY = "https://api.covid19api.com/{country}"            
    }
}