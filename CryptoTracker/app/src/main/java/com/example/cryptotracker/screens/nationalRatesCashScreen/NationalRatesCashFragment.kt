package com.example.cryptotracker.screens.nationalRatesCashScreen

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.cryptotracker.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class NationalRatesCashFragment : Fragment() {

    private lateinit var viewModel: NationalRatesCashViewModel
    private lateinit var spinner: Spinner
    private lateinit var adapter: NationalRatesCashAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_national_rates_cash_screen, container, false)

        spinner = view.findViewById(R.id.mySpinner)
        adapter = NationalRatesCashAdapter(requireContext())
        spinner.adapter = adapter



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
                Log.d("NationalRatesCash", "iso: ${selectedItem?.iso}, rate: ${selectedItem?.rate}")
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        return view
    }
}


