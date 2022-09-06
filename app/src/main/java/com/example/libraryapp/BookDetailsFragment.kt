package com.example.libraryapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import com.example.libraryapp.Book
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
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
        val binding = FragmentBookDetailsBinding.inflate(inflater, container, false)

        val main_activity : MainActivity = getActivity() as MainActivity

        //val model: BookDetailViewModel by viewModels(arguments?.getInt("book_id") as Int)
        val model: BookDetailViewModel by viewModels { BookDetailViewModelFactory(main_activity.rep, arguments?.getInt("book_id") as Int)}

        //model.setRepository(main_activity.rep)
        //model.selectBook()

        //val model: BookDetailViewModel = BookDetailViewModel(main_activity.rep, arguments?.getInt("book_id") as Int)

        binding.viewModel = model

        return binding.root
    }

    companion object {
    }
}