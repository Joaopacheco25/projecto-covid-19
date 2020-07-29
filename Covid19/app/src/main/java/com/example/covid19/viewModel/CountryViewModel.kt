package com.example.covid19.viewModel

data class CountryViewModel(
    val confirmed: Int,
    val deaths: Int,
    val recovered: Int,
    val active: Int,
    val date: String
)