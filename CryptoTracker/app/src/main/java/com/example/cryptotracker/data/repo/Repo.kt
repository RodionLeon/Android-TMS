package com.example.cryptotracker.data.repo

import com.example.cryptotracker.data.api.RetrofitInstance
import com.example.cryptotracker.model.cash.CashItem
import com.example.cryptotracker.model.cashless.CashlessItem
import retrofit2.Response

class Repo {
    suspend fun getCash(): Response<CashItem> {
        return RetrofitInstance.api.getCash()
    }

    suspend fun getCashless(): Response<CashlessItem> {
        return RetrofitInstance.api.getCashless()
    }
}