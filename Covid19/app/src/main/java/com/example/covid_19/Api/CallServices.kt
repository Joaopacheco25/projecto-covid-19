package com.example.covid_19.Api
import com.example.covid_19.Constants.Constant
import com.example.covid_19.Entity.Countries
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CallServices {

    @GET(Constant.URL_SUMMARY)
    fun get():Call<List<Countries>>

    @GET(Constant.URL_BY_COUNTRY)
    fun getByCountries(@Query("country") country: String):Call<Countries>
}