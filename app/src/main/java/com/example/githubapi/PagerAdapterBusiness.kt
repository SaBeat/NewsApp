package com.example.githubapi

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.githubapi.fragments.business_tab.FranceBusinessFragment
import com.example.githubapi.fragments.business_tab.TurkeyBusinessFragment
import com.example.githubapi.fragments.business_tab.UsBusinessFragment

class PagerAdapterBusiness(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 3;
    }

    override fun getItem(position: Int): Fragment {
        when(position) {
            0 -> {
                return TurkeyBusinessFragment()
            }
            1 -> {
                return UsBusinessFragment()
            }
            2 -> {
                return FranceBusinessFragment()
            }
            else -> {
                return TurkeyBusinessFragment()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position) {
            0 -> {
                return "Turkey"
            }
            1 -> {
                return "United States"
            }
            2 -> {
                return "France"
            }
        }
        return super.getPageTitle(position)
    }

}