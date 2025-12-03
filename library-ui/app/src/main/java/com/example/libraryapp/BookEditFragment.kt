package com.example.libraryapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.libraryapp.databinding.FragmentBookEditBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class BookEditFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val binding = FragmentBookEditBinding.inflate(inflater, container, false)

        val book_id = arguments?.getInt("book_id") as Int
        val user = arguments?.getParcelable("user") as User?
        val main_activity : MainActivity = getActivity() as MainActivity

        val model: BookEditViewModel by activityViewModels { BookEditViewModelFactory(main_activity.booksRepository, arguments?.getInt("book_id") as Int)}


        val view: View = binding.root

        val select_owner_button: Button = view.findViewById(R.id.buttonSelectOwner)
        val select_current_holder_button: Button = view.findViewById(R.id.buttonSelectCurrentHolder)
        val update_button: Button = view.findViewById(R.id.buttonUpdateBook)
        val delete_button: Button = view.findViewById(R.id.buttonDeleteBook)

        select_owner_button.setOnClickListener() {
            GlobalScope.launch(Dispatchers.Main) {
                parentFragmentManager
                    .beginTransaction()
                    .replace(R.id.nav_host_fragment, SelectOwnerFragment())
                    .addToBackStack("SelectOwnerFragment")
                    .commit()
            }
        }

        select_current_holder_button.setOnClickListener() {
            GlobalScope.launch(Dispatchers.Main) {
                parentFragmentManager
                    .beginTransaction()
                    .replace(R.id.nav_host_fragment, SelectCurrentHolderFragment())
                    .addToBackStack("SelectCurrentHolderFragment")
                    .commit()
            }
        }
        /*
        select_owner_button.setOnClickListener() {
            GlobalScope.launch(Dispatchers.Main) {
                val users = main_activity.usersRepository.getUserList()
                //val userNames = users.map { user -> user.username }.toTypedArray()
                val bundle = bundleOf("users" to users)
                val dialog = SelectUserDialogFragment()
                dialog.arguments = bundle
                dialog.setSelectCallback2 { user ->
                    Log.d("Edit Book", "user: " + user?.username)
                    model.owner.value = user
                }
                dialog.show(parentFragmentManager, "Select User Dialog")
            }
        }

        setFragmentResultListener("selectUser", { requestKey, bundle ->
            val selectedUser: User? = bundle.getParcelable("user")
            model.owner.value = selectedUser
        })

        select_current_holder_button.setOnClickListener() {
            GlobalScope.launch(Dispatchers.Main) {
                val users = main_activity.usersRepository.getUserList()
                val bundle = bundleOf("users" to users)
                val dialog = SelectUserDialogFragment()
                dialog.arguments = bundle
                dialog.show(parentFragmentManager, "Select User Dialog")
            }
        }

        setFragmentResultListener("selectUser", { requestKey, bundle ->
            val selectedUser: User? = bundle.getParcelable("user")
            model.currentHolder.value = selectedUser
        })

        */
        update_button.setOnClickListener() {
            val bundle = bundleOf("book_id" to book_id)

            //Dispatchers.IO causing navigation error
            GlobalScope.launch(Dispatchers.Main){
                model.update()
                view.findNavController().navigate(R.id.bookDetailsFragment, bundle)
            }
        }

        delete_button.setOnClickListener() {
            GlobalScope.launch(Dispatchers.IO) {
                model.delBook()
                Navigation.findNavController(view).navigate(R.id.action_book_delete)
            }
        }

        binding.viewModel = model
        binding.lifecycleOwner = this

        return binding.root

    }

}