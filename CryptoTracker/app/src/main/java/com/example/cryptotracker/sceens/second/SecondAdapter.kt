package com.example.cryptotracker.sceens.second

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptotracker.R
import com.example.cryptotracker.model.cashless.RateCashless
import javax.inject.Inject


class SecondAdapter @Inject constructor() : RecyclerView.Adapter<SecondAdapter.SecondViewHolder>() {
    var listSecond = emptyList<RateCashless>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SecondViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_money_layout, parent, false)
        return SecondViewHolder(view)
    }

    override fun onBindViewHolder(holder: SecondViewHolder, position: Int) {
        val rateList = listSecond[position]
        holder.itemView.findViewById<TextView>(R.id.sellIso).text = rateList.sellIso
        holder.itemView.findViewById<TextView>(R.id.buyIso).text = rateList.buyIso
        holder.itemView.findViewById<TextView>(R.id.item_buy).text = rateList.buyRate.toString()
        holder.itemView.findViewById<TextView>(R.id.item_sale).text = rateList.sellRate.toString()
    }

    override fun getItemCount(): Int {
        return listSecond.size
    }

    class SecondViewHolder(view: View) : RecyclerView.ViewHolder(view)

    fun setList(list: List<RateCashless>) {
        listSecond = list
        notifyDataSetChanged()
    }
}