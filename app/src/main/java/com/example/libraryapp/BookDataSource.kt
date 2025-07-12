package com.example.libraryapp

import android.util.Log

class BookDataSource(
    private val api: APIInterface,
    private val refreshIntervalMs: Long = 5000
) {


    suspend fun getBooks(): Array<Book> {
        return api.getBooks()
    }

    suspend fun getBook(id: Int): Book {
        return api.getBook(id)
    }

    suspend fun updateBook(id: Int, book: Book) {
        api.putBook(id, book)
    }

    suspend fun newBook(book: Book) {
        api.postBook(book)
    }


    suspend fun delBook(id: Int) {
        api.delBook(id)
    }

}
