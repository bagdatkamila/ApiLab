package com.example.apilab.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient


object ApiClient {

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val request = chain.request()


            val newRequest = request.newBuilder()
                .addHeader("X-Api-Key", "/ZbvraiQ0EFA+pPXsxG1NQ==8r1Ugi07Lk4V8Q2O")
                .build()

            chain.proceed(newRequest)
        }
        .build()

    private val gson = GsonBuilder().setLenient().create()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.api-ninjas.com/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()


    val instance = retrofit.create(AnimalService::class.java)
}