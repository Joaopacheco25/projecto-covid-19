package com.example.covid19.repository

import com.example.covid19.api.ClientApi
import com.example.covid19.api.GenericCallback
import com.example.covid19.entity.Covid

class RequestCountries(
    private val success:(Covid) -> Unit,
    private val failure:(Throwable) -> Unit
){
    fun getCountries(){
        val call = ClientApi.managersApi().get(auth = "Basic Auth")
        val callBack = GenericCallback(success, failure)
        call.enqueue(callBack)
    }
}