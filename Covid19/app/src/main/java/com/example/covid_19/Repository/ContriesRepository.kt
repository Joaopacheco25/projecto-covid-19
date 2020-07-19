package com.example.covid_19.Repository

import com.example.covid_19.Api.CovidApiService
import com.example.covid_19.Api.GenericCallBack
import com.example.covid_19.Entity.Countries
import com.example.covid_19.Entity.Covid

class RequestCountries(
    private val success:(List<Covid>) -> Unit,
    private val failure:(Throwable) -> Unit
){
    fun getCountries(){
        val call = CovidApiService.ClientApi.managersApi().get()
        val callBack = GenericCallBack(success , failure)
        call.enqueue(callBack);
    }
}