package com.example.covid19.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.covid19.R
import com.example.covid19.entity.Countries
import com.example.covid19.entity.Country
import com.example.covid19.entity.CountryItem
import com.example.covid19.entity.Covid
import com.example.covid19.repository.RequestCountries
import com.example.covid19.repository.RequestCountry
import com.example.covid19.viewModel.CountriesViewModel
import com.example.covid19.viewModel.CountryViewModel
import com.example.covid19.views.CountriesViewHolder.Companion.COUNTRY_NAME_EXTRA
import kotlinx.android.synthetic.main.activity_countries.*
import kotlinx.android.synthetic.main.activity_country.*

class CountryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country)

        val countryName = intent.getStringExtra(COUNTRY_NAME_EXTRA)

        head_country.text = countryName

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        val adapter = CountryAdapter()


        countryRecyclerView.layoutManager = layoutManager
        countryRecyclerView.adapter = adapter


        val requestCountries = RequestCountry(
            success = { countries -> adapter.updateList(toCountryViewModelList(countries)) },
            failure = { throwable ->
                Toast.makeText(this, throwable.message, Toast.LENGTH_LONG).show()
            }

        )
        requestCountries.getCountry(countryName)
    }

    private fun toCountryViewModelList(country: Country): List<CountryViewModel> {
        return country.map { raw -> toCountryViewModel(raw) }
    }

    private fun toCountryViewModel(country: CountryItem): CountryViewModel {
        return CountryViewModel(
            date = country.Date,
            active = country.Active,
            confirmed = country.Confirmed,
            deaths = country.Deaths,
            recovered = country.Recovered
        )
    }
}