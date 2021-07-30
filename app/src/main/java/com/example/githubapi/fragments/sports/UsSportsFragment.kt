package com.example.githubapi.fragments.sports

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubapi.CustomAdapter
import com.example.githubapi.NewsViewModel
import com.example.githubapi.R
import com.example.githubapi.model.Article
import com.example.githubapi.utils.Utils
import kotlinx.android.synthetic.main.fragment_us_news.*


class UsSportsFragment : Fragment() {

    lateinit var customAdapter: CustomAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_us_news, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
        getData(Utils.countryUs, Utils.API_KEY, Utils.categorySports)
    }

    private fun initRecycler() {
        recyclerView_united_states.apply {
            layoutManager = LinearLayoutManager(context)
            customAdapter = CustomAdapter(context)
            adapter = customAdapter
        }
    }

    private fun getData(country: String, apiKey: String, category: String) {
        val viewModel = ViewModelProviders.of(this).get(NewsViewModel::class.java)
        viewModel.newsObserver().observe(viewLifecycleOwner, Observer {
            customAdapter.setDataList(it.articles as ArrayList<Article>)
            customAdapter.notifyDataSetChanged()
        })

        viewModel.getApiData(country, apiKey, category)
    }

}