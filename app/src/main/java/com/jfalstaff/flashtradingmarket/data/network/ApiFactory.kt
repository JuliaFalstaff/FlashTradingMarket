package com.jfalstaff.flashtradingmarket.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {

    private const val BASE_URL = "https://run.mocky.io/"

    val retrofitLates = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api = retrofitLates.create(ApiService::class.java)
}