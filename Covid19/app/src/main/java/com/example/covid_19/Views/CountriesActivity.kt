package com.example.covid_19.Views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.covid_19.Entity.Countries
import com.example.covid_19.Entity.Covid
import com.example.covid_19.R
import com.example.covid_19.Repository.RequestCountries
import com.example.covid_19.ViewModel.CountryViewModel
import kotlinx.android.synthetic.main.activity_countries.*

class CountriesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_countries)

        val layoutManager = LinearLayoutManager(this)



        countriesRecyclerView.layoutManager = layoutManager
        val adapter = CountriesAdapter()



        val requestCountries = RequestCountries(
            success = {countries -> adapter.updateList(toCountryViewModelList(countries))},
            failure = {throwable -> Toast.makeText(this, throwable.message, Toast.LENGTH_LONG).show() }

        )
        var result =
            requestCountries.getCountries()
        print(result)
        countriesRecyclerView.adapter = adapter
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        countriesRecyclerView.layoutManager = layoutManager

    }

    private fun toCountryViewModelList(covidList: Covid):List<CountryViewModel>{
        return covidList.Countries.map { raw -> toCountryViewModel(raw) }
    }

    private fun toCountryViewModel(covid:Countries):CountryViewModel{
        return CountryViewModel(
            country = covid.Country,
            newConfirmed = covid.NewConfirmed
        )
    }
}