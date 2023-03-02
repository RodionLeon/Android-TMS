package com.example.cryptotracker.viewPager

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.cryptotracker.screens.root.RootFragment
import com.example.cryptotracker.screens.nationalRatesCashScreen.NationalRatesCashFragment
import com.example.cryptotracker.screens.cashScreen.CashFragment

class ViewPagerAdapter (rootFragment: RootFragment) :
    FragmentStateAdapter(rootFragment) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> CashFragment()
            else -> NationalRatesCashFragment()
        }

    }
}