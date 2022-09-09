package com.example.libraryapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.Navigation

class BookListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_book_list, container, false)


        val main_activity : MainActivity = getActivity() as MainActivity
        val arrayAdapter = getActivity()?.let { ArrayAdapter<String> (it.getApplicationContext(), android.R.layout.simple_list_item_1, main_activity.books) }
        val listView: ListView = view.findViewById(R.id.listView)
        listView.adapter = arrayAdapter


        val button: Button = view.findViewById(R.id.buttonNewBook)
        button.setOnClickListener() {
            Navigation.findNavController(view).navigate(R.id.action_new_book)
        }

        return view
    }

    companion object {

    }
}