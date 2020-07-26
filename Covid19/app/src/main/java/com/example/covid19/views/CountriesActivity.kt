package com.example.covid19.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.covid19.entity.Countries
import com.example.covid19.entity.Covid
import com.example.covid19.R
import com.example.covid19.repository.RequestCountries
import com.example.covid19.viewModel.CountriesViewModel
import kotlinx.android.synthetic.main.activity_countries.*

class CountriesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_countries)

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        val adapter = CountriesAdapter()


        countriesRecyclerView.layoutManager = layoutManager
        countriesRecyclerView.adapter = adapter


        val requestCountries = RequestCountries(
            success = { countries -> adapter.updateList(toCountryViewModelList(countries)) },
            failure = { throwable ->
                Toast.makeText(this, throwable.message, Toast.LENGTH_LONG).show()
            }

        )

        requestCountries.getCountries()


        country_search.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return false
            }

        })
    }

    private fun toCountryViewModelList(covidList: Covid): List<CountriesViewModel> {
        return covidList.Countries.map { raw -> toCountryViewModel(raw) }
    }

    private fun toCountryViewModel(covid: Countries): CountriesViewModel {
        return CountriesViewModel(
            country = covid.Country,
            newConfirmed = covid.NewConfirmed
        )
    }
}