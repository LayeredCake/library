package com.example.libraryapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.libraryapp.databinding.FragmentInsertBookBinding
import kotlinx.coroutines.*

class InsertBookFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentInsertBookBinding.inflate(inflater, container, false)
        val view: View = binding.root

        val main_activity : MainActivity = getActivity() as MainActivity

        val model: InsertBookViewModel by viewModels { InsertBookViewModelFactory(main_activity.rep) }

        val button: Button = view.findViewById(R.id.buttonCreateBook)

        button.setOnClickListener() {
            GlobalScope.launch(Dispatchers.Main) {
                model.add()
                Navigation.findNavController(view).navigate(R.id.action_create_book)
            }
        }

        binding.viewModel = model
        binding.lifecycleOwner = this

        return binding.root
    }

    companion object {

    }
}