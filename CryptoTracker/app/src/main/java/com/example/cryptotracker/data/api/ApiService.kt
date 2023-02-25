package com.example.cryptotracker.data.api

import com.example.cryptotracker.model.cash.CashItem
import com.example.cryptotracker.model.cashless.CashlessItem
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("partner/1.0.1/public/rates")
    suspend fun getCash(): Response<CashItem>

    @GET("partner/1.0.1/public/rates")
    suspend fun getCashless(): Response<CashlessItem>
}