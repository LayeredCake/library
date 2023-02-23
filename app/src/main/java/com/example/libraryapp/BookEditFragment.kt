package com.example.libraryapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import com.example.libraryapp.Book
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.libraryapp.databinding.FragmentBookDetailsBinding
import com.example.libraryapp.databinding.FragmentBookEditBinding


class BookEditFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentBookEditBinding.inflate(inflater, container, false)

        val book_id = arguments?.getInt("book_id") as Int
        val main_activity : MainActivity = getActivity() as MainActivity

        val model: BookEditViewModel by viewModels { BookEditViewModelFactory(main_activity.rep, arguments?.getInt("book_id") as Int)}

        val view: View = binding.root

        val update_button: Button = view.findViewById(R.id.buttonUpdateBook)
        val delete_button: Button = view.findViewById(R.id.buttonDeleteBook)
        val title: EditText = view.findViewById(R.id.txtTitle)
        val author: EditText = view.findViewById(R.id.txtAuthor)
        update_button.setOnClickListener() {
            //main_activity.rep.updateBook(Book(text.getText().toString(), "author"))
            val bundle = bundleOf("book_id" to book_id)
            //Navigation.findNavController(view).navigate(R.id.action_book_edit, bundle)
            view.findNavController().navigate(R.id.bookDetailsFragment, bundle)
        }
        delete_button.setOnClickListener() {
            model.delBook()
            Navigation.findNavController(view).navigate(R.id.action_book_delete)
        }

        binding.viewModel = model

        return binding.root
    }

    companion object {
    }
}