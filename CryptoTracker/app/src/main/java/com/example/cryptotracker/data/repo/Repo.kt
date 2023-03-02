package com.example.cryptotracker.data.repo

import com.example.cryptotracker.api.ApiService
import com.example.cryptotracker.model.cash.CashItem
import com.example.cryptotracker.model.cashForGraph.CashForGraphItem
import com.example.cryptotracker.model.nationalRatesCash.NationalRatesCashItem
import retrofit2.Response
import javax.inject.Inject


class Repo @Inject constructor(
    private val provideApiService: ApiService
) {

    suspend fun getCash(): Response<CashItem> {
        return provideApiService.getCash()
    }

    suspend fun getNationalRatesCash(): Response<NationalRatesCashItem> {
        return provideApiService.getNationalRatesCash()
    }

    suspend fun getCashForGraph(code:Int, date:String): Response<CashForGraphItem>{
        return provideApiService.getNationalRatesCashForGraph(code,date)
    }


}