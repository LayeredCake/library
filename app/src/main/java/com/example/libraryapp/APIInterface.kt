package com.example.libraryapp
import retrofit2.Call
import retrofit2.http.GET


interface APIInterface {
    @GET("Books")
    fun getBooks(): Call<Array<Book>>
}