package com.example.libraryapp

import android.widget.ArrayAdapter
import android.widget.ListView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BooksRepository() {
    private val books: MutableList<Book> = mutableListOf()

    fun getBooks(): MutableList<Book> {
        return books
    }

    fun updateBooks(newList: Array<Book>) {
        books.clear()
        books.addAll(newList)
    }

    fun updateBook(int: Int, book: Book) {

        val client = APIClient().getRetrofitClient().create(APIInterface::class.java)

        client.putBook(int, book).enqueue(object: Callback<Book> {
            override fun onResponse(call: Call<Book>, response: Response<Book>) {
            }

            override fun onFailure(call: Call<Book>, t: Throwable) {
                throw t
            }
        })
    }

    fun newBook(book: Book) {
        val client = APIClient().getRetrofitClient().create(APIInterface::class.java)

        client.postBook(book).enqueue(object: Callback<Book> {
            override fun onResponse(call: Call<Book>, response: Response<Book>) {
            }

            override fun onFailure(call: Call<Book>, t: Throwable) {
                throw t
            }
        })
    }

    fun getBook(id: Int): Book {
        return books[id]
    }

    fun delBook(int: Int) {
        val client = APIClient().getRetrofitClient().create(APIInterface::class.java)

        client.delBook(int).enqueue(object: Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                throw t
            }
        })
    }
}