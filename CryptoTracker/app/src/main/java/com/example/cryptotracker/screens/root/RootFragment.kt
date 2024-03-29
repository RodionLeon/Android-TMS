package com.example.cryptotracker.screens.root

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.cryptotracker.R
import com.example.cryptotracker.viewPager.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RootFragment : Fragment() {
   lateinit var adapter : ViewPagerAdapter

    private var ctx: Context? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        ctx = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_root, container,false )
        val tabLayout = view.findViewById<TabLayout>(R.id.tab_layout)
        val viewPager = view.findViewById<ViewPager2>(R.id.view_pager)
        adapter = ViewPagerAdapter(this)
        tabLayout.tabIconTint = null
        viewPager.adapter = adapter
        TabLayoutMediator(tabLayout, viewPager) { tab, pos ->
            when (pos) {
                0 -> {
                    tab.setIcon(R.drawable.ic_baseline_attach_money_24)
                }
                1 -> {
                    tab.setIcon(R.drawable.ic_baseline_monetization_on_24)
                }
            }
        }.attach()
        return view
    }
}