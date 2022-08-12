package com.sevval.countries.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.sevval.countries.*
import com.sevval.countries.databinding.FragmentSavedBinding
import com.sevval.countries.model.Data
import com.sevval.countries.repository.MainRepository
import com.sevval.countries.service.ApiService
import com.sevval.countries.viewmodel.CountryViewModel
import com.sevval.countries.viewmodel.CountryViewModelFactory

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class SavedFragment : Fragment(), CountryClickInterface {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    val apiService= ApiService()
    private lateinit var repo:MainRepository
    private lateinit var binding: FragmentSavedBinding
    private lateinit var countryViewModel: CountryViewModel
    lateinit var name:String
    val adapter= CountryAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

        binding= FragmentSavedBinding.inflate(layoutInflater)
        binding.recyclerView.adapter=adapter
        countryViewModel=
            ViewModelProvider(this, CountryViewModelFactory(MainRepository(apiService))).get(
                CountryViewModel::class.java
            )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SavedFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onCountryClick(data: Data) {
        TODO("Not yet implemented")
    }
}