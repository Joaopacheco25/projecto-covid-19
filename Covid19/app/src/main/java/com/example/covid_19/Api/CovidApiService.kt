package com.example.covid_19.Api

import com.example.covid_19.Constants.Constant
import okhttp3.logging.HttpLoggingInterceptor
import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit

class CovidApiService {
     object ClientApi {

         private val retrofit: Retrofit = retrofit()

         private fun logging(): HttpLoggingInterceptor {
             return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
         }

         private fun okHttpClient(): OkHttpClient {
             return OkHttpClient.Builder()
                 .addInterceptor(logging())
                 .build()
         }

         private fun retrofit():Retrofit{
             return Retrofit.Builder()
                 .baseUrl(Constant.BASE_URL)
                 .addConverterFactory(GsonConverterFactory.create(Gson()))
                 .client(okHttpClient())
                 .build()
         }

         fun managersApi(): CallServices {
             return retrofit.create(CallServices::class.java)
         }
    }
}