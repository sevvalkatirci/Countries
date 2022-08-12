package com.sevval.countries.viewmodel

import androidx.lifecycle.*
import com.sevval.countries.model.CountryData
import com.sevval.countries.model.Data
import com.sevval.countries.repository.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CountryViewModel(private val repository: MainRepository):ViewModel() {

    val countryList=MutableLiveData<List<Data>>()
    val errorMessage=MutableLiveData<String>()

    fun getAllCountries(){
        val response=repository.getAllCountries()
        response.enqueue(object : Callback<CountryData>{
            override fun onResponse(call: Call<CountryData>, response: Response<CountryData>) {
                countryList.postValue(response.body()?.data)
            }
            override fun onFailure(call: Call<CountryData>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}