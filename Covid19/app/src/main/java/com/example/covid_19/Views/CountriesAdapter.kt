package com.example.covid_19.Views

import android.view.LayoutInflater
import android.widget.TextView
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.covid_19.R
import com.example.covid_19.ViewModel.CountryViewModel


class CountriesAdapter():RecyclerView.Adapter<CoutriesViewHolder>(){

    private val countries = mutableListOf<CountryViewModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoutriesViewHolder {
        var view = LayoutInflater.from(parent!!.context).inflate(R.layout.countries_item, parent, false)
        return CoutriesViewHolder(view)
    }

    override fun getItemCount(): Int = countries.size

    override fun onBindViewHolder(holder: CoutriesViewHolder, position: Int) {
        val item = countries[position]
        holder.bind(item)
    }

    fun updateList(list: List<CountryViewModel>) {
        countries.clear()
        countries.addAll(list)
        notifyDataSetChanged()
    }
}

class CoutriesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    private val countryName = itemView.findViewById<TextView>(R.id.country_name)
    private val newCases = itemView.findViewById<TextView>(R.id.new_cases)

    fun bind(viewEntity: CountryViewModel){
            countryName.text = viewEntity.country
            newCases.text = viewEntity.newConfirmed.toString()
    }
}

