package com.example.libraryapp

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.setFragmentResult

class SelectUserDialogFragment(
): DialogFragment() {
    /*
    internal lateinit var listener: AlertDialogListener

    interface AlertDialogListener {
        fun onClickItem(dialog: DialogFragment)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            listener = context as AlertDialogListener
        } catch (e: ClassCastException) {
            throw ClassCastException((context.toString() + " must implement AlertDialogListener"))
        }

    }
    */

    var selectCallback: ((User?) -> Unit)? = null

    fun setSelectCallback2(selectCallback: (User?) -> Unit) {
        this.selectCallback = selectCallback
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val bundle = getArguments()
            /*
            if(bundle != null) {

                val keys: Set<String> = bundle.keySet()
                for (key in keys) {
                    Log.d("Select User", "key from bundle: " + key)
                }
            }
            */
            val users: Array<User>? = bundle?.getParcelableArray("users") as Array<User>?
            //Log.d("Select User", "user from list (in dialog): " + users?.get(0)?.username)
            val userNames = users?.map {user -> user.username }?.toTypedArray()
            builder.setTitle("Select a user")
                .setItems(userNames) { dialog, id ->
                    //Log.d("Select User","item id in dialog: " + id)
                    Log.d("Select User", "user: " + users?.get(id)?.username)
                    selectCallback?.invoke(users?.get(id))
                    //setFragmentResult("selectUser", bundleOf("user" to users?.get(id)))
                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

}