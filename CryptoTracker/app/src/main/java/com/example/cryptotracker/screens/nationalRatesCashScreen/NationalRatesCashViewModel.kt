package com.example.cryptotracker.screens.nationalRatesCashScreen


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptotracker.data.repo.Repo
import com.example.cryptotracker.model.nationalRatesCash.NationalRatesCashItem
import com.example.cryptotracker.model.nationalRatesCash.RateNationalRatesCash
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class NationalRatesCashViewModel @Inject constructor(private val repo: Repo) : ViewModel() {

    val items = MutableLiveData<List<RateNationalRatesCash>>()

    init {
        loadItems()
    }

    private fun loadItems() {
        viewModelScope.launch {
            val response = repo.getNationalRatesCash()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) {
                    items.postValue(body.rates)
                }
            }
        }
    }
}
