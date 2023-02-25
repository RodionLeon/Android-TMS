package com.example.cryptotracker.sceens.second

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptotracker.data.repo.Repo
import com.example.cryptotracker.model.cashless.CashlessItem
import kotlinx.coroutines.launch
import retrofit2.Response

class SecondViewModel : ViewModel() {
    var repo = Repo()
    val cashlessData: MutableLiveData<Response<CashlessItem>> = MutableLiveData()

    fun getCashlessMoney() {
        viewModelScope.launch {
            cashlessData.value = repo.getCashless()
        }
    }
}