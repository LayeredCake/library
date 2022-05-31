package com.example.libraryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {
    var book = Book("MaddAddam", "Margaret Atwood")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val title: TextView = findViewById(R.id.titleView)
        val author: TextView = findViewById(R.id.authorView)

        title.text = book.title
        author.text = "By: " + book.author

        val model: BookDetailViewModel by viewModels()
        model.book.observe(this, Observer<Book> { newBook ->
            book = newBook
            title.text = book.title
            author.text = "By: " + book.author
        })

    }
}