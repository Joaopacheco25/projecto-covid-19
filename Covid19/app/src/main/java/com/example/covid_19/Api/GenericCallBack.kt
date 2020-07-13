package com.example.covid_19.Api

import retrofit2.Call
import retrofit2.Response
import java.lang.IllegalStateException

class GenericCallBack<T>(
    private val success: (T) -> Unit,
    private val failure: (Throwable) -> Unit
):retrofit2.Callback<T>{

    override fun onResponse(call: Call<T>, response: Response<T>) {
        if (response.isSuccessful){
            onResponseSuccess(response.body())
        }else{
            failure(IllegalStateException("Response is not successful"))
        }
    }

    override fun onFailure(call: Call<T>, t: Throwable) {
        failure(t);
    }

    private fun onResponseSuccess(result: T?) {
        result?.let { success(it) } ?: failure(IllegalStateException("Body is null"))
    }
}