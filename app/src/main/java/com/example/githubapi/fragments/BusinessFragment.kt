package com.example.githubapi.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.githubapi.PagerAdapterBusiness
import com.example.githubapi.R
import kotlinx.android.synthetic.main.fragment_business.*


class BusinessFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_business, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewPager_business.adapter = PagerAdapterBusiness(childFragmentManager)
        tabLayout_business.setupWithViewPager(viewPager_business)
    }


}