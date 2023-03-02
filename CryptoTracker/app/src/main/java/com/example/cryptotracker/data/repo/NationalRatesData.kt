package com.example.cryptotracker.data.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.cryptotracker.model.nationalRatesCash.CashForSearchInApi
import com.example.cryptotracker.model.nationalRatesCash.NationalRatesCashItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

class NationalRatesData @Inject constructor(private val repo: Repo) {

    private val nationalRatesCashData: MutableList<Response<NationalRatesCashItem>> =
        mutableListOf()

 private fun getCashMoney(): MutableList<Response<NationalRatesCashItem>> {
        CoroutineScope(Dispatchers.IO).launch {
            nationalRatesCashData[0] = repo.getNationalRatesCash()
        }
        return nationalRatesCashData
    }

    private val dataOfNationalRatesCash = getCashMoney()


    private val cashForSearch = CashForSearchInApi.fillCurrencyCodeMap(dataOfNationalRatesCash[0])


}