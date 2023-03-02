package com.example.cryptotracker.screens.nationalRatesCashScreen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptotracker.R
import com.example.cryptotracker.model.nationalRatesCash.RateNationalRatesCash
import javax.inject.Inject


class NationalRatesCashAdapter @Inject constructor() : RecyclerView.Adapter<NationalRatesCashAdapter.SecondViewHolder>() {
    var listSecond = emptyList<RateNationalRatesCash>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SecondViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_money_layout, parent, false)
        return SecondViewHolder(view)
    }

    override fun onBindViewHolder(holder: SecondViewHolder, position: Int) {
        val rateList = listSecond[position]
        holder.itemView.findViewById<TextView>(R.id.buyIso).text = rateList.name
        holder.itemView.findViewById<TextView>(R.id.item_buy).text = rateList.rate.toString()
        holder.itemView.findViewById<TextView>(R.id.item_sale).text = rateList.date
    }

    override fun getItemCount(): Int {
        return listSecond.size
    }

    class SecondViewHolder(view: View) : RecyclerView.ViewHolder(view)

    fun setList(list: List<RateNationalRatesCash>) {
        listSecond = list
        notifyDataSetChanged()
    }
}