package com.sevval.countries

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sevval.countries.databinding.LayoutRvItemBinding
import com.sevval.countries.model.Data
import com.sevval.countries.view.fragments.CountryClickInterface

class CountryAdapter( val countryClickInterface: CountryClickInterface):RecyclerView.Adapter<CountryViewHolder>() {

    var countries= mutableListOf<Data>()

    fun setCountryList(countries:List<Data>){
        this.countries=countries.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val inflater=LayoutInflater.from(parent.context)
        val binding=LayoutRvItemBinding.inflate(inflater,parent,false)
        return CountryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country=countries[position]
        holder.binding.CountryName.text=country.name
        holder.binding.CountryName.setOnClickListener{
            Log.d("adapter",country.name)
            countryClickInterface.onCountryClick(country)
        }
    }

    override fun getItemCount(): Int {
        return countries.size
    }
}

class CountryViewHolder(val binding: LayoutRvItemBinding):RecyclerView.ViewHolder(binding.root){ }