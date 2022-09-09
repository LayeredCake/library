package com.example.libraryapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.os.bundleOf
import androidx.navigation.findNavController


class BookListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_book_list, container, false)


        val listView: ListView = view.findViewById(R.id.listView)


        val main_activity : MainActivity = getActivity() as MainActivity
        val books = main_activity.rep.getBooks().toTypedArray()

        val arrayAdapter = getActivity()?.let { ArrayAdapter<Book> (it.getApplicationContext(), android.R.layout.simple_list_item_1, books) }

        listView.adapter = arrayAdapter

        listView.setOnItemClickListener { parent, view, position, id ->

            val index = position
            val bundle = bundleOf("book_id" to index)
            view.findNavController().navigate(R.id.bookDetailsFragment, bundle)
        }

        return view
    }

}