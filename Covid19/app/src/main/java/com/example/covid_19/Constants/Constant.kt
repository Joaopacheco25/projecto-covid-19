package com.example.covid_19.Constants

interface Constant  {
    companion object {
        const val BASE_URL= "https://api.covid19api.com"
        const val SUMMARY_URL = "https://api.covid19api.com/summary"
        const val URL_BY_COUNTRY = "https://api.covid19api.com/{country}"            
    }
}