package com.example.cryptotracker.sceens.start

import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptotracker.R
import com.example.cryptotracker.model.cash.CashItem
import kotlinx.android.synthetic.main.item_money_layout.view.*

class StartAdapter() : RecyclerView.Adapter<StartAdapter.StartViewHolder>() {

    var listStart = emptyList<CashItem>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StartViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_money_layout, parent, false)
        return StartViewHolder(view)
    }

    override fun onBindViewHolder(holder: StartViewHolder, position: Int) {
        holder.itemView.item_name.text = listStart[position].ccy
        holder.itemView.item_buy.text = listStart[position].buy
        holder.itemView.item_sale.text = listStart[position].sale
    }

    override fun getItemCount(): Int {
        return listStart.size
    }

    class StartViewHolder(view: View) : RecyclerView.ViewHolder(view)

    fun setList(list: List<CashItem>) {
        listStart = list
        notifyDataSetChanged()
    }


}