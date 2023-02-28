package com.example.cryptotracker.viewPager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.cryptotracker.sceens.root.RootFragment
import com.example.cryptotracker.sceens.second.SecondFragment
import com.example.cryptotracker.sceens.start.StartFragment
import javax.inject.Inject

class ViewPagerAdapter (rootFragment: RootFragment) :
    FragmentStateAdapter(rootFragment) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> StartFragment()
            else -> SecondFragment()
        }

    }
}