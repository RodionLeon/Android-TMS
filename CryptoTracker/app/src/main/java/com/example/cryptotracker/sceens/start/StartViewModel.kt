package com.example.cryptotracker.sceens.start

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptotracker.data.repo.Repo
import com.example.cryptotracker.model.cash.CashItem
import kotlinx.coroutines.launch
import retrofit2.Response

class StartViewModel : ViewModel() {

    var repo = Repo()
    val cashData: MutableLiveData<Response<CashItem>> = MutableLiveData()

    fun getCashMoney() {
        viewModelScope.launch {
            cashData.value = repo.getCash()
        }
    }
}