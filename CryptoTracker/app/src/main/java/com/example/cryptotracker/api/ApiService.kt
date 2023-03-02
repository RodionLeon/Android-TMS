package com.example.cryptotracker.api

import com.example.cryptotracker.model.cash.CashItem
import com.example.cryptotracker.model.cashForGraph.CashForGraphItem
import com.example.cryptotracker.model.nationalRatesCash.NationalRatesCashItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("partner/1.0.1/public/rates")
    suspend fun getCash(): Response<CashItem>

    @GET("partner/1.0.1/public/nationalRates")
    suspend fun getNationalRatesCash(): Response<NationalRatesCashItem>

    @GET("partner/1.0.1/public/nationalRates")
    suspend fun getNationalRatesCashForGraph(@Query("currencyCode") code: Int, @Query("date") date: String): Response<CashForGraphItem>
}