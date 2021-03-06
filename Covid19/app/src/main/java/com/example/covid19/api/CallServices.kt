package com.example.covid19.api

import com.example.covid19.constants.Constant
import com.example.covid19.entity.Country
import com.example.covid19.entity.Covid
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface CallServices {

    @GET(Constant.SUMMARY_URL)
    fun get(@Header("Authorization") auth: String): Call<Covid>

    @GET(Constant.URL_BY_COUNTRY)
    fun getByCountries(@Path("country") country: String): Call<Country>
}