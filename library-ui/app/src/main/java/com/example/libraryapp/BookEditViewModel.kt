package com.example.libraryapp

import androidx.lifecycle.*
import kotlinx.coroutines.launch

class BookEditViewModel(val repository: BooksRepository, val id: Int) : ViewModel() {

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
            val book = repository.getBook(id)
            author.value = book.author
            title.value = book.title
            series.value = book.series
            pageCount.value = book.pageCount.toString()
            owner.value = book.owner
            genre.value = book.genre
            currentHolder.value = book.currentHolder
            condition.value = book.condition
            format.value = book.format
        }
    }

    suspend fun update() {
        val updatedBook = Book(title.value!!, author.value!!, series.value!!, pageCount.value!!.toInt(), owner.value!!, genre.value!!, currentHolder.value!!, condition.value!!, format.value!!, id)
        repository.updateBook(id, updatedBook)
    }

    suspend fun delBook() {
        repository.delBook(id)
    }

}