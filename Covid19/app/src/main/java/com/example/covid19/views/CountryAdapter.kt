package com.example.covid19.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.covid19.R
import com.example.covid19.viewModel.CountryViewModel
import java.time.LocalDate

class CountryAdapter() :
    RecyclerView.Adapter<CountryViewHolder>() {

    private var countryList = ArrayList<CountryViewModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.country_item, parent, false);
        return CountryViewHolder(view);
    }

    override fun getItemCount(): Int =
        countryList.size


    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val item = countryList[position]
        holder.bind(item)
    }

    fun updateList(list: List<CountryViewModel>) {
        countryList.clear()
        list.sortedWith(compareBy { it.date })
        countryList.addAll(list)
        notifyDataSetChanged()
    }
}

class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val countryActive = itemView.findViewById<TextView>(R.id.country_active)
    private val countryDate = itemView.findViewById<TextView>(R.id.country_date)
    private val countryDeaths = itemView.findViewById<TextView>(R.id.country_deaths)
    private val countryNewConfirmed = itemView.findViewById<TextView>(R.id.country_new_confirmed)
    private val countryRecovered = itemView.findViewById<TextView>(R.id.country_recovered)

    fun bind(viewEntity: CountryViewModel) {
        countryActive.text = viewEntity.active.toString()
        //  countryDate.text = LocalDate.parse(viewEntity.date).toString()
        countryDate.text = (viewEntity.date)
        countryDeaths.text = viewEntity.deaths.toString()
        countryNewConfirmed.text = viewEntity.confirmed.toString()
        countryRecovered.text = viewEntity.recovered.toString()
    }
}