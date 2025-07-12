package com.example.libraryapp

import android.app.Application
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.lifecycle.*
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class BookEditViewModel(val repository: BooksRepository, val id: Int) : ViewModel() {

    var author = MutableLiveData<String>()
    var title = MutableLiveData<String>()
    var series = MutableLiveData<String>()
    var pageCount = MutableLiveData<String>()
    var owner = MutableLiveData<String>()
    var genre = MutableLiveData<String>()
    var currentHolder = MutableLiveData<String>()
    var condition = MutableLiveData<String>()
    var format = MutableLiveData<String>()


    init {
        viewModelScope.launch {
            val book = repository.getBook(id)
            author.value = book.author
            title.value = book.title
            series.value = book.series
            pageCount.value = book.pageCount.toString()
            owner.value = book.owner
            genre.value = book.genre.toString()
            currentHolder.value = book.currentHolder
            condition.value = book.condition.toString()
            format.value = book.format.toString()
        }
    }

    suspend fun update() {
        val updatedBook = Book(title.value!!, author.value!!, series.value!!, pageCount.value!!.toInt(), owner.value!!, genre.value!!.toInt(), currentHolder.value!!, condition.value!!.toInt(), format.value!!.toInt(), id)
        repository.updateBook(id, updatedBook)
    }

    suspend fun delBook() {
        repository.delBook(id)
    }

}