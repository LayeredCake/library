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

/**
 * A simple [Fragment] subclass.
 * Use the [BookDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BookDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val book_id = arguments?.getInt("book_id") as Int
        val binding = FragmentBookDetailsBinding.inflate(inflater, container, false)

        val main_activity : MainActivity = getActivity() as MainActivity

        val view: View = binding.root

        val button: Button = view.findViewById(R.id.buttonEditBook)
        button.setOnClickListener() {
            val bundle = bundleOf("book_id" to book_id)
            //Navigation.findNavController(view).navigate(R.id.action_book_edit, bundle)
            view.findNavController().navigate(R.id.editBookFragment, bundle)
        }

        val model: BookDetailViewModel by viewModels { BookDetailViewModelFactory(main_activity.rep, book_id)}

        binding.viewModel = model

        return binding.root
    }

    companion object {
    }
}