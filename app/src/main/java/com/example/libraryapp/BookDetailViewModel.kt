package com.example.libraryapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BookDetailViewModel : ViewModel() {

    var book: MutableLiveData<Book> = MutableLiveData<Book>(Book("Exhalation", "Ted Chiang"))

}