package com.example.covid19.views

import android.content.Intent
import android.view.LayoutInflater
import android.widget.TextView
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.example.covid19.R
import com.example.covid19.viewModel.CountriesViewModel
import java.util.*
import kotlin.collections.ArrayList


class CountriesAdapter() :
    RecyclerView.Adapter<CountriesViewHolder>(), Filterable {

    private var countryFilterList = ArrayList<CountriesViewModel>() //ListUsedToFilter

    private var countriesList: ArrayList<CountriesViewModel> =
        ArrayList<CountriesViewModel>() //List with all countries to avoid another call to api after filter the list

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.countries_item, parent, false)
        return CountriesViewHolder(view)
    }

    override fun getItemCount(): Int = countryFilterList.size

    override fun onBindViewHolder(holder: CountriesViewHolder, position: Int) {
        val item = countryFilterList[position]
        holder.bind(item)
    }

    fun updateList(list: List<CountriesViewModel>) {
        countriesList.clear()
        countryFilterList.clear()
        countriesList.addAll(list)
        countryFilterList.addAll(list)
        notifyDataSetChanged()
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSequence = constraint.toString()

                countryFilterList = if (charSequence.isEmpty()) {
                    countriesList
                } else {
                    val resultCountries = ArrayList<CountriesViewModel>()
                    for (row in countriesList) if (row.country.toLowerCase(Locale.ROOT)
                            .contains(charSequence.toLowerCase(Locale.ROOT))
                    ) {
                        resultCountries.add(row)
                    }
                    resultCountries
                }

                val filterResults = FilterResults()
                filterResults.values = countryFilterList
                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                countryFilterList = results?.values as ArrayList<CountriesViewModel>
                notifyDataSetChanged()
            }

        }
    }


}

class CountriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val countryName = itemView.findViewById<TextView>(R.id.countries_name)
    private val newCases = itemView.findViewById<TextView>(R.id.countries_new_cases)
    private val btnDetails = itemView.findViewById<Button>(R.id.btn_details);

    fun bind(viewEntity: CountriesViewModel) {
        countryName.text = viewEntity.country
        newCases.text = viewEntity.newConfirmed.toString()
        btnDetails.setOnClickListener(View.OnClickListener {
            val intent = Intent(itemView.context, CountryActivity::class.java)
            intent.putExtra(COUNTRY_NAME_EXTRA, viewEntity.country)
            itemView.context.startActivity(intent)
        })
    }

    companion object {
        const val COUNTRY_NAME_EXTRA = "country-name"
    }
}

