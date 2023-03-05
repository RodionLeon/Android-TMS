package com.example.cryptotracker.screens.cashScreen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptotracker.R
import com.example.cryptotracker.model.cash.Rate
import javax.inject.Inject


class CashAdapter @Inject constructor() : RecyclerView.Adapter<CashAdapter.StartViewHolder>() {

    var listStart = emptyList<Rate>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StartViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_money_layout, parent, false)
        return StartViewHolder(view)
    }

    override fun onBindViewHolder(holder: StartViewHolder, position: Int) {
        val rateList = listStart[position]
        holder.itemView.findViewById<TextView>(R.id.sellIso).text = rateList.sellIso
        holder.itemView.findViewById<TextView>(R.id.buyIso).text = rateList.buyIso
        holder.itemView.findViewById<TextView>(R.id.item_buy).text = rateList.buyRate.toString()
        holder.itemView.findViewById<TextView>(R.id.item_sale).text = rateList.sellRate.toString()
    }

    override fun getItemCount(): Int {
        return listStart.size
    }

  inner class StartViewHolder(view: View) : RecyclerView.ViewHolder(view)

    fun setList(list: List<Rate>) {
        listStart = list
        notifyDataSetChanged()
    }
}