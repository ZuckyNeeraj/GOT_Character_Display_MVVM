package com.example.got_app_mvvm.repository

import com.example.got_app_mvvm.model.DataItem
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://thronesapi.com/api/v2/"

class ItemRepository{
    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiInterface::class.java)

    fun getItems(): Call<List<DataItem>> {
        return api.getItems()
    }
}