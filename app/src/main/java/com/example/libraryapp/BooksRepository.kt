package com.example.libraryapp

class BooksRepository() {
    private val books: MutableList<Book> = mutableListOf(Book("The Graveyard Book", "Neil Gaiman"), Book("The Martian", "Andy Weir"), Book("Mistborn", "Brandon Sanderson"), Book("Great Expectations", "Charles Dickens"))

    fun getBooks(): MutableList<Book> {
        return books
    }

    fun addBook(newBook: Book) {
        books.add(newBook)
    }

    fun getBook(id: Int): Book {
        return books[id]
    }

    fun delBook(id: Int) {
        books.removeAt(id);
    }
}