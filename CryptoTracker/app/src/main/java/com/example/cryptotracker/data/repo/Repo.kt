package com.example.cryptotracker.data.repo

import com.example.cryptotracker.api.ApiService
import com.example.cryptotracker.model.cash.CashItem
import com.example.cryptotracker.model.cashless.CashlessItem
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Response
import javax.inject.Inject


class Repo @Inject constructor(
    private val provideApiService: ApiService
) {

    suspend fun getCash(): Response<CashItem> {
        return provideApiService.getCash()
    }

    suspend fun getCashless(): Response<CashlessItem> {
        return provideApiService.getCashless()
    }
}