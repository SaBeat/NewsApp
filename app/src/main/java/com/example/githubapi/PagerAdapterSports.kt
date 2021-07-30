package com.example.githubapi

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.githubapi.fragments.sports.FranceSportsFragment
import com.example.githubapi.fragments.sports.TurkeySportsFragment
import com.example.githubapi.fragments.sports.UsSportsFragment

class PagerAdapterSports(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 3;
    }

    override fun getItem(position: Int): Fragment {
        when(position) {
            0 -> {
                return TurkeySportsFragment()
            }
            1 -> {
                return UsSportsFragment()
            }
            2 -> {
                return FranceSportsFragment()
            }
            else -> {
                return TurkeySportsFragment()
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