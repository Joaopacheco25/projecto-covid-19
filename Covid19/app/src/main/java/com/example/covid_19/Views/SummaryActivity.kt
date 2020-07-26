package com.example.covid19.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.covid19.entity.Countries
import com.example.covid19.entity.Covid
import com.example.covid19.R
import com.example.covid19.viewModelSummaryViewModel

class SummaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        val adapter = summaryAdapter()


        summaryRecyclerView.layoutManager = layoutManager
        summaryRecyclerView.adapter = adapter


        val requestSummary = RequestSummary(
                success = { summary -> adapter.updateList(toSummaryViewModel(summary)) },
            failure = { throwable -> Toast.makeText(this, throwable.message, Toast.LENGTH_LONG).show() }

        )

        requestSummary();
    }

    private fun toSummaryViewModelList(covidList: Covid):List<CountryViewModel>{
        return covidList.Countries.map { raw -> toSummaryViewModel(raw) }
    }

    private fun toSummaryViewModel(covid: Countries): SummaryViewModel {
        return SumaryViewModel(
            /*
                country = covid.Country,
            newConfirmed = covid.NewConfirmed

             */
        )
    }
}