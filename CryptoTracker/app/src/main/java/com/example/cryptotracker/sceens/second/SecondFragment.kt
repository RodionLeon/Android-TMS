package com.example.cryptotracker.sceens.second

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
class SecondFragment : Fragment() {
    @Inject
    lateinit var adapter: SecondAdapter

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModel = ViewModelProvider(this).get(SecondViewModel::class.java)

        val view = inflater.inflate(R.layout.fragment_second, container, false)
        recyclerView = view.findViewById(R.id.rv_second)
        adapter = SecondAdapter()
        recyclerView.adapter = adapter
        viewModel.getCashlessMoney()
        viewModel.cashlessData.observe(viewLifecycleOwner) { response ->
            if (response.isSuccessful) {
                response.body()?.let {
                    adapter.setList(it.rates)
                }
            }
        }
        return view
    }
}


