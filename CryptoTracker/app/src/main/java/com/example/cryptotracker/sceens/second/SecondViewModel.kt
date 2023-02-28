package com.example.cryptotracker.sceens.second

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptotracker.data.repo.Repo
import com.example.cryptotracker.model.cashless.CashlessItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class SecondViewModel @Inject constructor(
    private val repo: Repo
) : ViewModel() {

    val cashlessData: MutableLiveData<Response<CashlessItem>> = MutableLiveData()

    fun getCashlessMoney() {
        viewModelScope.launch {
            cashlessData.value = repo.getCashless()
        }
    }
}