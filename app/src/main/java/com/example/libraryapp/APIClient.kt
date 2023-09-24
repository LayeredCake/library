package com.example.libraryapp
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIClient {
    fun getRetrofitClient(): Retrofit {
        val gson = GsonBuilder().setLenient().create()
        var builder = Retrofit.Builder()
        builder = builder.baseUrl("http://192.168.86.96:5022/api/")
        builder = builder.addConverterFactory(GsonConverterFactory.create(gson))
        return builder.build()
        }
}