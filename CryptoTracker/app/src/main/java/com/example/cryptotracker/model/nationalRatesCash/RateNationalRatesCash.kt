package com.example.cryptotracker.model.nationalRatesCash

data class RateNationalRatesCash(
    val code: Int,
    val date: String,
    val iso: String,
    val name: String,
    val quantity: Int,
    val rate: Double
)

