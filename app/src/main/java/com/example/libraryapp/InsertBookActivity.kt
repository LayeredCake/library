package com.example.libraryapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation

class InsertBookActivity : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.activity_insert_book, container, false)

        val button: Button = view.findViewById(R.id.buttonCreateBook)
        val text: EditText = view.findViewById(R.id.txtTitle)
        button.setOnClickListener() {
            //Navigation.findNavController(view).navigate()
        }
        return view
    }
}