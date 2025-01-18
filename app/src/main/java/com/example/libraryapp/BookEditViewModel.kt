package com.example.libraryapp

import android.app.Application
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BookEditViewModel(val repository: BooksRepository, val id: Int) : ViewModel() {

    fun getBook(): Book {
        return repository.getBook(id)
    }

    fun getAuthor(): String {
        return repository.getBook(id).author
    }

    fun getTitle(): String {
        return repository.getBook(id).title
    }

    fun getSeries(): String {
        return repository.getBook(id).series
    }

    fun getPageCount(): String {
        return repository.getBook(id).pageCount.toString()
    }

    fun getOwner(): String {
        return repository.getBook(id).owner
    }

    fun getGenre(): String {
        return repository.getBook(id).genre
    }

    fun getCurrentHolder(): String {
        return repository.getBook(id).currentHolder
    }

    fun getCondition(): String {
        return repository.getBook(id).condition
    }

    fun getFormat(): String {
        return repository.getBook(id).format
    }



    fun setTitle(title: String) {
        if(repository.getBook(id).title != title) {
            val book: Book = repository.getBook(id)
            book.title = title

            repository.updateBook(book.id!!, book)
        }
    }

    fun setAuthor(author: String) {
        if(repository.getBook(id).author != author) {
            val book: Book = repository.getBook(id)
            book.author = author
            repository.updateBook(book.id!!, book)
        }
    }

    fun setSeries(series: String) {
        if(repository.getBook(id).series != series) {
            val book: Book = repository.getBook(id)
            book.series = series
            repository.updateBook(book.id!!, book)
        }
    }

    fun setPageCount(pageCount: String) {
        if(repository.getBook(id).pageCount != pageCount.toInt()) {
            val book: Book = repository.getBook(id)
            book.pageCount = pageCount.toInt()
            repository.updateBook(book.id!!, book)
        }
    }

    fun setOwner(owner: String) {
        if(repository.getBook(id).owner != owner) {
            val book: Book = repository.getBook(id)
            book.owner = owner
            repository.updateBook(book.id!!, book)
        }
    }

    fun setGenre(genre: String) {
        if(repository.getBook(id).genre != genre) {
            val book: Book = repository.getBook(id)
            book.genre = genre
            repository.updateBook(book.id!!, book)
        }
    }

    fun setCurrentHolder(currentHolder: String) {
        if(repository.getBook(id).currentHolder != currentHolder) {
            val book: Book = repository.getBook(id)
            book.currentHolder = currentHolder
            repository.updateBook(book.id!!, book)
        }
    }

    fun setCondition(condition: String) {
        if(repository.getBook(id).condition != condition) {
            val book: Book = repository.getBook(id)
            book.condition = condition
            repository.updateBook(book.id!!, book)
        }
    }

    fun setFormat(format: String) {
        if(repository.getBook(id).format != format) {
            val book: Book = repository.getBook(id)
            book.format = format
            repository.updateBook(book.id!!, book)
        }
    }

    fun delBook() {
        repository.delBook(repository.getBook(id).id!!)
    }

}