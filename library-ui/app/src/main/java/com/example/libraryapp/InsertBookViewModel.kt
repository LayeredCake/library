package com.example.libraryapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class InsertBookViewModel (val repository: BooksRepository) : ViewModel() {

    var author = MutableLiveData<String>()
    var title = MutableLiveData<String>()
    var series = MutableLiveData<String>()
    var pageCount = MutableLiveData<String>()
    var owner = MutableLiveData<String>()
    var genre = MutableLiveData<Int>()
    var currentHolder = MutableLiveData<String>()
    var condition = MutableLiveData<Int>()
    var format = MutableLiveData<Int>()

    init {
        viewModelScope.launch {
            author.value = ""
            title.value = ""
            series.value = ""
            pageCount.value = ""
            owner.value = ""
            genre.value = 0
            currentHolder.value = ""
            condition.value = 0
            format.value = 0
        }
    }

    suspend fun add() {
        val newBook = Book(
            title.value!!,
            author.value!!,
            series.value!!,
            pageCount.value!!.toInt(),
            owner.value!!,
            genre.value!!,
            currentHolder.value!!,
            condition.value!!,
            format.value!!,
            0
        )
        repository.newBook(newBook)
    }

}