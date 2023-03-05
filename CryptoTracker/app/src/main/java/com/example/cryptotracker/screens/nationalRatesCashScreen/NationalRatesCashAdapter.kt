package com.example.cryptotracker.screens.nationalRatesCashScreen


import android.content.Context
import android.util.Log
import android.view.LayoutInflater

import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.cryptotracker.R
import com.example.cryptotracker.model.nationalRatesCash.RateNationalRatesCash
import javax.inject.Inject


class NationalRatesCashAdapter @Inject constructor(context: Context) :
    ArrayAdapter<RateNationalRatesCash>(context, R.layout.item_national_rates_cash, R.id.textViewCurrencyIso) {

    private var items: List<RateNationalRatesCash> = emptyList()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        val holder: ViewHolder
        if (view == null) {
            view = LayoutInflater.from(parent.context).inflate(R.layout.item_national_rates_cash, parent, false)
            holder = ViewHolder(
                view.findViewById(R.id.textViewCurrencyIso)
            )
            view.tag = holder
        } else {
            holder = view.tag as ViewHolder
        }
        val item = items[position]
        holder.textViewCurrencyIso.text = item.iso
        return view!!
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        val holder: ViewHolder
        if (view == null) {
            view = LayoutInflater.from(parent.context).inflate(R.layout.item_national_rates_cash_dropdown, parent, false)
            holder = ViewHolder(
                view.findViewById(R.id.textViewCurrencyIso)
            )
            view.tag = holder
        } else {
            holder = view.tag as ViewHolder
        }
        val item = items[position]
        holder.textViewCurrencyIso.text = item.iso

        return view!!
    }

    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): RateNationalRatesCash? {
        return items.getOrNull(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    fun setItems(newItems: List<RateNationalRatesCash>) {
        items = newItems
        notifyDataSetChanged()
    }

    inner class ViewHolder(
        val textViewCurrencyIso: TextView
    )
}