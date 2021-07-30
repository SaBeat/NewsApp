package com.example.githubapi

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.githubapi.fragments.science.FranceScienceFragment
import com.example.githubapi.fragments.science.TurkeyScienceFragment
import com.example.githubapi.fragments.science.UsScienceFragment

class PagerAdapterScience(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 3;
    }

    override fun getItem(position: Int): Fragment {
        when(position) {
            0 -> {
                return TurkeyScienceFragment()
            }
            1 -> {
                return UsScienceFragment()
            }
            2 -> {
                return FranceScienceFragment()
            }
            else -> {
                return TurkeyScienceFragment()
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