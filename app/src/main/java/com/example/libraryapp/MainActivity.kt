package com.example.libraryapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    val books = arrayOf<String>("The Graveyard Book", "The Martian", "Mistborn", "Great Expectations")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val arrayAdapter = ArrayAdapter<String> (this, android.R.layout.simple_list_item_1, books)
        val listView: ListView = findViewById(R.id.listView)
        listView.adapter = arrayAdapter
        val intent = Intent(this, InsertBookActivity::class.java)
        startActivity(intent)
    }

}