package com.example.libraryapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.Navigation

class InsertBookFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_insert_book, container, false)

        val main_activity : MainActivity = getActivity() as MainActivity

        val button: Button = view.findViewById(R.id.buttonCreateBook)
        val titleText: EditText = view.findViewById(R.id.txtTitle)
        val authorText: EditText = view.findViewById(R.id.txtAuthor)
        val seriesText: EditText = view.findViewById(R.id.txtSeries)
        val pageCountText: EditText = view.findViewById(R.id.txtPageCount)
        val ownerText: EditText = view.findViewById(R.id.txtOwner)
        val genreText: EditText = view.findViewById(R.id.txtGenre)
        val currentHolderText: EditText = view.findViewById(R.id.txtCurrentHolder)
        val conditionText: EditText = view.findViewById(R.id.txtCondition)
        val formatText: EditText = view.findViewById((R.id.txtFormat))

        button.setOnClickListener() {
            main_activity.rep.newBook(Book(
                titleText.getText().toString(),
                authorText.getText().toString(),
                seriesText.getText().toString(),
                pageCountText.getText().toString().toInt(),
                ownerText.getText().toString(),
                genreText.getText().toString(),
                currentHolderText.getText().toString(),
                conditionText.getText().toString(),
                formatText.getText().toString(),
                null))

            Navigation.findNavController(view).navigate(R.id.action_create_book)
        }
        return view
    }

    companion object {

    }
}