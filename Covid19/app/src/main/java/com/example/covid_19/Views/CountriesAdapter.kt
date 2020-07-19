package com.example.covid_19.Views

import android.view.LayoutInflater
import android.widget.TextView
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.covid_19.Entity.Covid
import com.example.covid_19.R


class CountriesAdapter(val countriesList: List<Covid>?):RecyclerView.Adapter<CoutriesViewHolder>(){

    private val countries = mutableListOf<Covid>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoutriesViewHolder {
        var view = LayoutInflater.from(parent!!.context).inflate(R.layout.countries_item, parent, false)
        return CoutriesViewHolder(view)
    }

    override fun getItemCount(): Int = countriesList!!.size

    override fun onBindViewHolder(holder: CoutriesViewHolder, position: Int) {
        holder.bind(countriesList, position)
    }

    fun updateList(list: List<Covid>) {
        countries.clear()
        countries.addAll(list)
        notifyDataSetChanged()
    }
}

class CoutriesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    private val countryName = itemView.findViewById<TextView>(R.id.country_name)
    private val newCases = itemView.findViewById<TextView>(R.id.new_cases)

    fun bind(viewEntity: List<Covid>?, position: Int){
            countryName.text = viewEntity!![0].countries[position].Country
            newCases.text = viewEntity!![0].countries[position].NewConfirmed.toString()
    }
}

