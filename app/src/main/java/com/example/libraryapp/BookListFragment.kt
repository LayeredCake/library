package com.example.libraryapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import androidx.navigation.Navigation

class BookListFragment : Fragment() {

    var books = arrayOf<Book>()

    private fun getBookList() {
        val client = APIClient().getRetrofitClient().create(APIInterface::class.java)

        client.getBooks().enqueue(object: Callback<Array<Book>> {
            override fun onResponse(call: Call<Array<Book>>, response: Response<Array<Book>>) {
                books = response.body() as Array<Book>

                val main_activity : MainActivity = getActivity() as MainActivity
                main_activity.updateBooks(books)
                val listView: ListView? = view?.findViewById(R.id.listView)
                val arrayAdapter = getActivity()?.let { ArrayAdapter<Book> (it.getApplicationContext(), android.R.layout.simple_list_item_1, books) }
                listView?.adapter = arrayAdapter
            }
            override fun onFailure(call: Call<Array<Book>>, t: Throwable) {
                throw t
            }
        })
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_book_list, container, false)


        val listView: ListView = view.findViewById(R.id.listView)

        val app_context: Context? = this.context

        if(app_context != null) {
            /*
            val arrayAdapter = activity?.let {
                BookAdapter(
                    app_context,
                    android.R.layout.activity_list_item,
                    books
                )
            }
            */
            val arrayAdapter = getActivity()?.let { ArrayAdapter<Book> (it.getApplicationContext(), android.R.layout.simple_list_item_1, books) }

            listView.adapter = arrayAdapter

            getBookList()


            listView.setOnItemClickListener { parent, view, position, id ->

                val index = position
                val bundle = bundleOf("book_id" to index)
                view.findNavController().navigate(R.id.bookDetailsFragment, bundle)
            }
        }

        val button: Button = view.findViewById(R.id.buttonNewBook)
        button.setOnClickListener() {
            Navigation.findNavController(view).navigate(R.id.action_new_book)
        }

        return view
    }

}