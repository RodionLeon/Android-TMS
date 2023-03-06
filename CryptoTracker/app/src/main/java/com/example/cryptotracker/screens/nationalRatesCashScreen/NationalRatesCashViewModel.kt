package com.example.cryptotracker.screens.nationalRatesCashScreen


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptotracker.data.repo.Repo
import com.example.cryptotracker.model.cashForGraph.RateForGraph
import com.example.cryptotracker.model.nationalRatesCash.NationalRatesCashItem
import com.example.cryptotracker.model.nationalRatesCash.RateNationalRatesCash
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import java.time.LocalDate
import java.time.format.DateTimeFormatter
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
                    items.value = body.rates
                }
            }
        }
    }

    private val _ratesForGraph = MutableLiveData<List<RateForGraph>>()
    val ratesForGraph: LiveData<List<RateForGraph>> = _ratesForGraph

    fun getNationalRatesCashForGraph(currencyCode: Int, numDays: Int) {
        viewModelScope.launch {
            val endDate = LocalDate.now()
            val dates = (0 until numDays).map { endDate.minusDays(it.toLong()) }
            val rates = mutableListOf<RateForGraph>()
            for (date in dates) {
                val response = repo.getCashForGraph(currencyCode, date.format(
                    DateTimeFormatter.ofPattern("dd.MM.yyyy")))
                if (response.isSuccessful) {
                    rates.addAll(response.body()?.rates ?: emptyList())
                }
            }
            _ratesForGraph.value = rates.sortedBy { LocalDate.parse(it.date, DateTimeFormatter.ofPattern("dd.MM.yyyy")) }
        }
    }
}
