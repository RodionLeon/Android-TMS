package com.example.cryptotracker.model.nationalRatesCash

import android.util.Log
import retrofit2.Response

object CashForSearchInApi {

    fun fillCurrencyCodeMap(response: Response<NationalRatesCashItem>) : MutableMap<String,Int> {
        val currencyCodeMap: MutableMap<String, Int> = HashMap()
        if (response.isSuccessful) {
            val rates = response.body()?.rates
            rates?.let { ratesList ->
                for (rate in ratesList) {
                    currencyCodeMap[rate.iso] = rate.code
                }
            }
        }
        return currencyCodeMap
    }
}