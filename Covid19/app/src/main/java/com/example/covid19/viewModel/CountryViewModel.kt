package com.example.covid19.viewModel

import java.util.*

data class CountryViewModel(
    val confirmed: Int,
    val deaths: Int,
    val recovered: Int,
    val active: Int,
    val date: String
)