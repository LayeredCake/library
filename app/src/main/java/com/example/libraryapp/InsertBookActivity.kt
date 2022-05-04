package com.example.libraryapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class InsertBookActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert_book)
        val button: Button = findViewById(R.id.buttonCreateBook)
        val text: EditText = findViewById(R.id.txtTitle)
        button.setOnClickListener() {
            val intent = Intent()
            intent.putExtra("title", text.text)
            setResult(RESULT_OK, intent)
            finish()
        }
    }

}