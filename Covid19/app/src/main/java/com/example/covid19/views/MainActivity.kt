package com.example.covid19.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.TextView
import android.widget.Toast
import com.example.covid19.R
import com.example.covid19.entity.Covid
import com.example.covid19.repository.RequestCountries
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val requestCountries = RequestCountries(
            success = { covid -> toGlobalViewModel(covid) },
            failure = { throwable ->
                Toast.makeText(this, throwable.message, Toast.LENGTH_LONG).show()
            }
        )

        requestCountries.getCountries()

        countries_btn.setOnClickListener { goToCountriesActivity() }
    }

    private fun toGlobalViewModel(country: Covid) {
        val newCases = findViewById<TextView>(R.id.new_confirmed_global)
        val totalConfirmed = findViewById<TextView>(R.id.total_confirmed_global)
        val newDeaths = findViewById<TextView>(R.id.new_deaths_global)
        val totalDeaths = findViewById<TextView>(R.id.total_deaths_global)
        val newRecovered = findViewById<TextView>(R.id.new_recovered_global)
        val totalRecovered = findViewById<TextView>(R.id.total_recovered_global)
        newCases.text = country.Global.NewConfirmed.toString()
        totalConfirmed.text = country.Global.TotalConfirmed.toString()
        newDeaths.text = country.Global.NewDeaths.toString()
        totalDeaths.text = country.Global.TotalDeaths.toString()
        newRecovered.text = country.Global.NewRecovered.toString()
        totalRecovered.text = country.Global.TotalRecovered.toString()
    }

    private fun goToCountriesActivity() {
        val intent = Intent(this, CountriesActivity::class.java)
        startActivity(intent)
    }
}