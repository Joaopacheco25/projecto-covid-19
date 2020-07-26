package com.example.covid19.repository

import com.example.covid19.api.ClientApi
import com.example.covid19.api.GenericCallback
import com.example.covid19.entity.Country
import com.example.covid19.entity.Covid

class RequestCountry(
    private val success: (Country) -> Unit,
    private val failure: (Throwable) -> Unit
) {

    fun getCountry(country: String) {
        val call = ClientApi.managersApi().getByCountries(country)
        val callBack = GenericCallback(success, failure)
        call.enqueue(callBack);
    }
}