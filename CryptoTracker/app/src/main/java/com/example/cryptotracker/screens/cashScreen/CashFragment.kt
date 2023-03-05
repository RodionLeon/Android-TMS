package com.example.cryptotracker.screens.cashScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptotracker.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CashFragment : Fragment() {
    @Inject
    lateinit var adapter: CashAdapter

    private lateinit var recyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModel = ViewModelProvider(this).get(CashViewModel::class.java)

        val view = inflater.inflate(R.layout.fragment_cash_screen, container, false)
        recyclerView = view.findViewById(R.id.rv_start)
        adapter = CashAdapter()
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
