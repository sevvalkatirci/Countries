package com.sevval.countries.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sevval.countries.repository.MainRepository

class CountryViewModelFactory constructor(private val repository: MainRepository) :ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if(modelClass.isAssignableFrom(CountryViewModel::class.java)){
            CountryViewModel(this.repository) as T
        }else{
            throw IllegalArgumentException("ViewModel not Found")
        }
    }
}