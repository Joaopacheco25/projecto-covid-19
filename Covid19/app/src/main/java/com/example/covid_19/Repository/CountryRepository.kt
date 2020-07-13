package com.example.covid_19.Repository

import com.example.covid_19.Api.CovidApiService
import com.example.covid_19.Api.GenericCallBack
import com.example.covid_19.Entity.Countries

class RequestCountry(
    private val success:(Countries) -> Unit,
    private val failure:(Throwable) -> Unit
){

    fun getCountry(country:String){
        val  call = CovidApiService.ClientApi.managersApi().getByCountrie(country)
        val  callBack = GenericCallBack(success, failure)
        call.enqueue(callBack);
    }

}