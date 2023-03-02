package com.example.cryptotracker.screens.nationalRatesCashScreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptotracker.data.repo.Repo
import com.example.cryptotracker.model.cashForGraph.CashForGraphItem
import com.example.cryptotracker.model.nationalRatesCash.NationalRatesCashItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class NationalRatesCashViewModel @Inject constructor(
    private val repo: Repo
) : ViewModel() {

    val cashlessData: MutableLiveData<Response<CashForGraphItem>> = MutableLiveData()

    fun getCashlessMoney() {
        viewModelScope.launch {
            cashlessData.value = repo.getCashForGraph(840, "01.02.2023")
        }
    }
}