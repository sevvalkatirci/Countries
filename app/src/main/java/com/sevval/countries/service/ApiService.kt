package com.sevval.countries.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val  BASE_URL="https://wft-geo-db.p.rapidapi.com/"
class ApiService {

    val retrofitBuilder = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()
        .create(ApiInterface::class.java)
}