package com.example.libraryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.libraryapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var book = Book("MaddAddam", "Margaret Atwood")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val model: BookDetailViewModel by viewModels()
        binding.viewModel = model

    }
}