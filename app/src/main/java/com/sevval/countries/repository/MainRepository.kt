package com.sevval.countries.repository
import com.sevval.countries.service.ApiService

class MainRepository(private val apiService: ApiService) {

    fun getAllCountries()=apiService.retrofitBuilder.getData()
}