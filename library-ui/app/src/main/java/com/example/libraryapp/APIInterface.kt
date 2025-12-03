package com.example.libraryapp
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*
import java.nio.file.attribute.UserPrincipal


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

    @GET("Users")
    suspend fun getUsers(): Array<User>

    @GET("Users/{id}")
    suspend fun getUser(@Path("id") id: Int): User

    @PUT("Users/{id}")
    suspend fun putUser(@Path("id") id: Int, @Body user: User): Response<Unit>

    @DELETE("Users/{id}")
    suspend fun delUser(@Path("id") id: Int): Response<Unit>

    @POST("Users")
    suspend fun postUser(@Body user: User): User

}