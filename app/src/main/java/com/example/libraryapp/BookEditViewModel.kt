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
            repository.getBook(id).title = title
        }
    }

    fun setAuthor(author: String) {
        if(repository.getBook(id).author != author) {
            repository.getBook(id).author = author
        }
    }

    fun delBook() {
        repository.delBook(id)
    }

}