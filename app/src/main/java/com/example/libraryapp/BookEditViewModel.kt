package com.example.libraryapp

import android.app.Application
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BookEditViewModel(val repository: BooksRepository, val id: Int) : ViewModel() {

    fun getBook(): Book {
        return repository.getBook(id)
    }

    fun getAuthor(): String {
        return repository.getBook(id).author
    }

    fun getTitle(): String {
        return repository.getBook(id).title
    }


    fun setTitle(title: String) {
        if(repository.getBook(id).title != title) {
            val book: Book = repository.getBook(id)
            book.title = title

            repository.updateBook(book.id!!, book)
        }
    }

    fun setAuthor(author: String) {
        if(repository.getBook(id).author != author) {
            val book: Book = repository.getBook(id)
            book.author = author
            repository.updateBook(book.id!!, book)
        }
    }

    fun delBook() {
        repository.delBook(repository.getBook(id).id!!)
    }

}