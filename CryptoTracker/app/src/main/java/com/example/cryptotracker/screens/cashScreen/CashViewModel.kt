package com.example.cryptotracker.screens.cashScreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptotracker.data.repo.Repo
import com.example.cryptotracker.model.cash.CashItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject
@HiltViewModel
class CashViewModel @Inject constructor(private val repo: Repo ) : ViewModel() {

    val cashData: MutableLiveData<Response<CashItem>> = MutableLiveData()

    fun getCashMoney() {
        viewModelScope.launch {
            cashData.value = repo.getCash()
        }
    }
}