package com.example.covid_19.Views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.covid_19.Entity.Covid
import com.example.covid_19.R
import com.example.covid_19.Repository.RequestCountries
import kotlinx.android.synthetic.main.activity_countries.*

class CountriesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_countries)

        val layoutManager = LinearLayoutManager(this)

        countriesRecyclerView.layoutManager = layoutManager


        val requestCountries = RequestCountries(
            success = {countries -> countriesRecyclerView.adapter = CountriesAdapter(countries)},
            failure = {throwable -> Toast.makeText(this, throwable.message, Toast.LENGTH_LONG).show() }

        )
        requestCountries.getCountries()
    }
}