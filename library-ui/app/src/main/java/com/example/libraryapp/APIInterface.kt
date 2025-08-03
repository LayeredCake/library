package com.example.libraryapp
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*


interface APIInterface {
    @GET("Books")
    suspend fun getBooks(): Array<Book>

    @GET("Books/{id}")
    suspend fun getBook(@Path("id") id: Int): Book

    @PUT("Books/{id}")
    suspend fun putBook(@Path("id") id: Int, @Body book: Book): Response<Unit>

    @DELETE("Books/{id}")
    suspend fun delBook(@Path("id") id: Int): Response<Unit>

    @POST("Books")
    suspend fun postBook(@Body book: Book): Book
}