package com.example.libraryapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.os.bundleOf
import androidx.navigation.findNavController

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BookList.newInstance] factory method to
 * create an instance of this fragment.
 */
class BookListFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    val books = arrayOf<Book>(Book("The Graveyard Book", "Neil Gaiman"), Book("The Martian", "Andy Weir"), Book("Mistborn", "Brandon Sanderson"), Book("Great Expectations", "Charles Dickens"))


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_book_list, container, false)


        val listView: ListView = view.findViewById(R.id.listView)
        val textView: TextView = view.findViewById(R.id.textView)

        val arrayAdapter = getActivity()?.let { ArrayAdapter<Book> (it.getApplicationContext(), android.R.layout.simple_list_item_1, books) }

        listView.adapter = arrayAdapter

        listView.setOnItemClickListener { parent, view, position, id ->

            val index = position
            val bundle = bundleOf("book_id" to index)
            view.findNavController().navigate(R.id.bookDetailsFragment, bundle)
        }

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BookList.
         */
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BookListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}