package com.example.libraryapp
import retrofit2.Call
import retrofit2.http.*


interface APIInterface {
    @GET("Books")
    fun getBooks(): Call<Array<Book>>

    @PUT("Books/{id}")
    fun putBook(@Path("id") id: Int, @Body book: Book): Call<Book>

    @DELETE("Books/{id}")
    fun delBook(@Path("id") id: Int): Call<Void>

    @POST("Books")
    fun postBook(@Body book: Book): Call<Book>
}