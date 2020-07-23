package com.example.covid19.api

import com.example.covid19.constants.Constant
import okhttp3.logging.HttpLoggingInterceptor
import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit


     object ClientApi {

         private val retrofit: Retrofit =
             retrofit()

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
             return retrofit.create(
                 CallServices::class.java)
         }
    }
