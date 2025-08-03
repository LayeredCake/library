package com.example.libraryapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class InsertBookViewModelFactory(val repository: BooksRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(BooksRepository::class.java).newInstance(repository)
    }

}