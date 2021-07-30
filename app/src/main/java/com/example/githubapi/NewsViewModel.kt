package com.example.githubapi

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.githubapi.api.ApiInterface
import com.example.githubapi.api.RetrofitClient
import com.example.githubapi.model.NewsData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsViewModel :ViewModel() {

    var newsList:MutableLiveData<NewsData> = MutableLiveData()

     fun newsObserver():MutableLiveData<NewsData>{
        return newsList
    }

     fun getApiData(country:String,apiKey:String,category:String){
       val instance=RetrofitClient.getInstance().create(ApiInterface::class.java)
        val call=instance.getHeadlines(country,apiKey,category)
        call.enqueue(object :Callback<NewsData>{
            override fun onResponse(call: Call<NewsData>, response: Response<NewsData>) {
                if(response.isSuccessful){
                    newsList.postValue(response.body())
                }else{
                    newsList.postValue(null)
                }
            }

            override fun onFailure(call: Call<NewsData>, t: Throwable) {
                newsList.postValue(null)
            }

        })
    }

}