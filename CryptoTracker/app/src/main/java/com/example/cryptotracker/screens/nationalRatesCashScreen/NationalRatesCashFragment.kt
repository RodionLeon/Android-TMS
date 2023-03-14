package com.example.cryptotracker.screens.nationalRatesCashScreen

import android.graphics.Color
import android.icu.text.SimpleDateFormat
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.cryptotracker.R
import com.example.cryptotracker.utils.Constants.Companion.MONTH
import com.example.cryptotracker.utils.Constants.Companion.WEEK
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.listener.OnChartValueSelectedListener
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.util.*


@AndroidEntryPoint
class NationalRatesCashFragment : Fragment() {

    private lateinit var viewModel: NationalRatesCashViewModel
    private lateinit var spinner: Spinner
    private lateinit var adapter: NationalRatesCashAdapter
    private lateinit var chart: LineChart
    private lateinit var weekButton: Button
    private lateinit var monthButton: Button

    private var currencyIso: String = ""
    private var daysCount : Int = 0
    private var currencyCode: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(
            R.layout.fragment_national_rates_cash_screen,
            container,
            false
        )

        spinner = view.findViewById(R.id.mySpinner)
        adapter = NationalRatesCashAdapter(requireContext())
        spinner.adapter = adapter

        chart = view.findViewById(R.id.chart)
        weekButton = view.findViewById(R.id.button)
        monthButton = view.findViewById(R.id.button2)

        viewModel = ViewModelProvider(this).get(NationalRatesCashViewModel::class.java)
        viewModel.items.observe(viewLifecycleOwner) { items ->
            adapter.setItems(items)
        }

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedItem = adapter.getItem(position)
                Log.d(
                    "NationalRatesCash",
                    "iso: ${selectedItem?.iso}, rate: ${selectedItem?.rate}"
                )
                selectedItem?.let {
                    currencyIso = it.iso
                    currencyCode = it.code
                    fetchGraphData()

                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        weekButton.setOnClickListener {
            daysCount = WEEK
            fetchGraphData()
        }

        monthButton.setOnClickListener {
            daysCount = MONTH
            fetchGraphData()
        }

        return view
    }

    private fun fetchGraphData() {
        viewModel.getNationalRatesCashForGraph(currencyCode, daysCount)
        viewModel.ratesForGraph.observe(viewLifecycleOwner) { rates ->
            val entries = mutableListOf<Entry>()
            for (i in rates.indices) {
                val rate = rates[i]
                entries.add(Entry(i.toFloat(), rate.rate.toFloat()))
            }
            displayGraph(entries)
        }
    }

    private fun displayGraph(entries: List<Entry>) {
        val dataSet = LineDataSet(entries, "Цена")
        dataSet.color = Color.BLUE
        dataSet.setDrawValues(false)
        val data = LineData(dataSet)

        chart.data = data
        chart.invalidate()
        chart.setOnChartValueSelectedListener(object : OnChartValueSelectedListener {
            override fun onValueSelected(e: Entry?, h: Highlight?) {
                if (e != null) {
                    Toast.makeText(requireContext(), "Курс: ${e.y}", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onNothingSelected() {}
        })
    }
}


