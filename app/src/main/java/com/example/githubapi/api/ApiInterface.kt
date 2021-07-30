package com.example.githubapi.api

import com.example.githubapi.model.NewsData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("top-headlines")
    fun getHeadlines(
        @Query("country") country:String,
        @Query("apiKey") apiKey:String,
        @Query("category") category:String
    ): Call<NewsData>
}