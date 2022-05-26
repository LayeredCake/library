package com.example.libraryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import layout.Book

class MainActivity : AppCompatActivity() {
    val book = Book("MaddAddam", "Margaret Atwood")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val title: TextView = findViewById(R.id.titleView)
        title.text = book.title
        val author: TextView = findViewById(R.id.authorView)
        author.text = "By: " + book.author
    }
}