package com.example.githubapi.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.githubapi.CustomAdapter
import com.example.githubapi.PagerAdapterScience
import com.example.githubapi.R
import kotlinx.android.synthetic.main.fragment_science.*


class ScienceFragment : Fragment() {

    lateinit var customAdapter: CustomAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_science, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewPager_science.adapter = PagerAdapterScience(childFragmentManager)
        tabLayout_science.setupWithViewPager(viewPager_science)
    }


}