package com.example.cryptotracker.model.cashless

data class RateCashless(
    val buyCode: Int,
    val buyIso: String,
    val buyRate: Double,
    val date: String,
    val name: String,
    val quantity: Int,
    val sellCode: Int,
    val sellIso: String,
    val sellRate: Double
)