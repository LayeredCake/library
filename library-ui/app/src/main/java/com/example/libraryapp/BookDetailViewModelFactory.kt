package com.example.libraryapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class BookDetailViewModelFactory(val repository: BooksRepository, val id: Int): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        return modelClass.getConstructor(BooksRepository::class.java, Int::class.java).newInstance(repository, id)
    }

}



