package com.example.libraryapp

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class BookAdapter(private val adapterContext: Context, private val id: Int, books: Array<Book>):
    ArrayAdapter<Book>(adapterContext, id, books) {
        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            var convertView = convertView
            if (convertView == null) {
                val inflater = (adapterContext as Activity).layoutInflater
                convertView = inflater.inflate(id, parent, false)
            }
            try {
                val book: Book? = getItem(position)
                val bookTitleView = convertView!!.findViewById<View>(R.id.titleView) as TextView
                bookTitleView.text = book?.title
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return convertView!!
        }
    }