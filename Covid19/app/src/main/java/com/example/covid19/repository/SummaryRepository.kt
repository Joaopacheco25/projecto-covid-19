package com.example.covid19.repository

import com.example.covid19.api.ClientApi
import com.example.covid19.api.GenericCallback
import com.example.covid19.entity.Covid

class RequestSummary(
    private val success:(Covid) -> Unit,
    private val failure:(Throwable) -> Unit
){

    fun getSummary(summary:String){
        val  call = ClientApi.managersApi().getCovid()
        val  callBack = GenericCallback(success, failure)
        call.enqueue(callBack);
    }
}