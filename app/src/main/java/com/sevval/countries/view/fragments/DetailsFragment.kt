package com.sevval.countries.view.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.sevval.countries.viewmodel.CountryViewModel
import com.sevval.countries.databinding.FragmentDetailsBinding
import com.sevval.countries.model.Data
import com.sevval.countries.service.ApiService

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class DetailsFragment(val data : Data) : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding:FragmentDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        binding= FragmentDetailsBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding.detailTitle.text=data.name
        binding.editCodeTxt.text=data.code

        Glide.with(this).load("https://upload.wikimedia.org/wikipedia/commons/thumb/0/00/Flag_of_the_Vatican_City.svg/2048px-Flag_of_the_Vatican_City.svg.png").into(binding.flagImage)

        binding.infoButton.setOnClickListener {
            val url = "https://www.wikidata.org/wiki/${data.wikiDataId}"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }
        return binding.root
    }
}