package com.example.libraryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.viewModels

class MainActivity : AppCompatActivity() {
    var books = arrayOf<Book>(Book("The Graveyard Book", "Neil Gaiman"), Book("The Martian", "Andy Weir"), Book("Mistborn", "Brandon Sanderson"), Book("Great Expectations", "Charles Dickens"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Database()
    }

    fun updateBooks(newBooks: Array<Book>) {
        books = newBooks
    }
}