package com.example.libraryapp

import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BooksRepository(private val bookDataSource: BookDataSource) {

    suspend fun getBookList(): Array<Book> {
        return bookDataSource.getBooks()
    }

    suspend fun getBook(id: Int): Book {
        return bookDataSource.getBook(id)
    }

    suspend fun updateBook(int: Int, book: Book) {
        bookDataSource.updateBook(int, book)
    }

    suspend fun newBook(book: Book) {
        bookDataSource.newBook(book)
    }

    suspend fun delBook(int: Int) {
        bookDataSource.delBook(int)
    }
}