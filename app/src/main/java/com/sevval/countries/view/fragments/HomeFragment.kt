package com.sevval.countries.view.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sevval.countries.*
import com.sevval.countries.databinding.FragmentHomeBinding
import com.sevval.countries.model.Data
import com.sevval.countries.repository.MainRepository
import com.sevval.countries.service.ApiService
import com.sevval.countries.viewmodel.CountryViewModel
import com.sevval.countries.viewmodel.CountryViewModelFactory

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HomeFragment : Fragment(), CountryClickInterface {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private val TAG="HomeFragment"
    private lateinit var binding: FragmentHomeBinding
    private lateinit var countryViewModel: CountryViewModel
    private val apiService=ApiService()
    val adapter=CountryAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

        binding= FragmentHomeBinding.inflate(layoutInflater)
        countryViewModel=
            ViewModelProvider(this, CountryViewModelFactory(MainRepository(apiService))).get(
                CountryViewModel::class.java
            )
        binding.recyclerView.adapter=adapter

        countryViewModel.countryList.observe(this, Observer {
            Log.d(TAG,"countryList:$it")
            adapter.setCountryList(it)
        })
        countryViewModel.errorMessage.observe(this, Observer {
            Log.d(TAG,"errormessage:$it")
        })

        countryViewModel.getAllCountries()


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
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onCountryClick(data: Data) {
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        transaction?.replace(R.id.mainContainer,DetailsFragment(data))
        transaction?.commit()
    }
}