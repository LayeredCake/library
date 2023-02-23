package com.example.libraryapp

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BookDetailViewModel(val repository: BooksRepository, val id: Int) : ViewModel() {

    val book : Book get() { return repository.getBook(id) }

    /*
    fun deleteBook() {
        repository.deleteBook(id)
    }
    */
}