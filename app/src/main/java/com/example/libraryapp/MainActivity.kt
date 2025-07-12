package com.example.libraryapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.viewModels

import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    val api: APIInterface = APIClient().getRetrofitClient().create(APIInterface::class.java)

    val rep: BooksRepository = BooksRepository(BookDataSource(api))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}