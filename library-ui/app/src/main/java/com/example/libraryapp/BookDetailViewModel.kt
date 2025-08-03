package com.example.libraryapp

import androidx.lifecycle.*
import kotlinx.coroutines.launch

class BookDetailViewModel(val repository: BooksRepository, val id: Int) : ViewModel() {

    private val _book = MutableLiveData<Book>()
    val book: LiveData<Book> = _book

    init {
        viewModelScope.launch {
            _book.value = repository.getBook(id)
        }
    }
}