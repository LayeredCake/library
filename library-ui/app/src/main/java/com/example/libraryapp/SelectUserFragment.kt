package com.example.libraryapp

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.navigation.findNavController

import androidx.navigation.Navigation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

abstract class SelectUserFragment : Fragment() {

    abstract fun callback(user: User): Unit

    var viewModel: BookEditViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_select_user, container, false)

        val listView: ListView = view.findViewById(R.id.listView)

        viewModel = ViewModelProvider(requireActivity()).get(BookEditViewModel::class.java)

        val app_context: Context? = this.context

        var users = arrayOf<User>()

        if(app_context != null) {
            lifecycleScope.launch {

                val main_activity : MainActivity = getActivity() as MainActivity
                users = main_activity.usersRepository.getUserList()
                val arrayAdapter = getActivity()?.let { ArrayAdapter<User> (it.getApplicationContext(), android.R.layout.simple_list_item_1, users) }

                listView.adapter = arrayAdapter

            }

        }

        listView.setOnItemClickListener { parent, view, position, id ->

            val user = users[position]
            callback(user)
            parentFragmentManager.popBackStack()
        }

        return view
    }

}