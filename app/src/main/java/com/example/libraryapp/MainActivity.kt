package com.example.libraryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.viewModels

class MainActivity : AppCompatActivity() {
    val books = arrayOf<Book>(Book("The Graveyard Book", "Neil Gaiman"), Book("The Martian", "Andy Weir"), Book("Mistborn", "Brandon Sanderson"), Book("Great Expectations", "Charles Dickens"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val arrayAdapter = ArrayAdapter<Book>(this, android.R.layout.simple_list_item_1, books)
        val listView: ListView = findViewById(R.id.listView)
        listView.adapter = arrayAdapter
    }
}