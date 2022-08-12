package com.sevval.countries.service

import com.sevval.countries.model.CountryData
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("v1/geo/countries?offset=0&limit=10&rapidapi-key=f44c66acd2msheae7cb6a38dd70ap16bba1jsne1f7c6868256")
    fun getData(): Call<CountryData>
}