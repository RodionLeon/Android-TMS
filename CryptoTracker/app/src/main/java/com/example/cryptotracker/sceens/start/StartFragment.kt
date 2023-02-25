package com.example.cryptotracker.sceens.start

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptotracker.R
import com.example.cryptotracker.model.cash.CashItem
import com.example.cryptotracker.model.cash.Rate


class StartFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: StartAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModel = ViewModelProvider(this).get(StartViewModel::class.java)

        val view = inflater.inflate(R.layout.fragment_start, container, false)
        recyclerView = view.findViewById(R.id.rv_start)
        adapter = StartAdapter()
        recyclerView.adapter = adapter
        viewModel.getCashMoney()
        viewModel.cashData.observe(viewLifecycleOwner) { response ->
            if (response.isSuccessful) {
                response.body()?.let {
                    adapter.setList(it.rates)
                }
            }
        }
        return view
    }
}
