package com.example.covid19.views

import android.view.LayoutInflater
import android.widget.TextView
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.covid19.R
import com.example.covid19.viewModel.CountryViewModel


class SummaryAdapter():RecyclerView.Adapter<CoutriesViewHolder>(){

    private val summary = mutableListOf<SummaryViewModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoutriesViewHolder {
        var view = LayoutInflater.from(parent!!.context).inflate(R.layout.countries_item, parent, false)
        return SummaryViewHolder(view)
    }

    override fun getItemCount(): Int = countries.size

    override fun onBindViewHolder(holder: SummaryViewHolder, position: Int) {
        val item = countries[position]
        holder.bind(item)
    }

    fun updateList(list: List<SummaryViewModel>) {
        summary.clear()
        summary.addAll(list)
        notifyDataSetChanged()
    }
}

class SummaryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    private val countryName = itemView.findViewById<TextView>(R.id.country_name)
    private val newCases = itemView.findViewById<TextView>(R.id.new_cases)

    fun bind(viewEntity: SummaryViewModel)
    {
            newCases.text = viewEntity.newConfirmed.toString()
            newDeaths.text = viewEntity.newConfirmed.toString()
            newRecovered.text = viewEntity.newConfirmed.toString()
    }
}

