package com.example.libraryapp

class BooksRepository(private val bookDataSource: BookDataSource) {

    suspend fun getBookList(): Array<Book> {
        return bookDataSource.getBooks()
    }

    suspend fun getBook(id: Int): Book {
        return bookDataSource.getBook(id)
    }

    suspend fun updateBook(int: Int, book: Book) {
        bookDataSource.updateBook(int, book)
    }

    suspend fun newBook(book: Book) {
        bookDataSource.newBook(book)
    }

    suspend fun delBook(int: Int) {
        bookDataSource.delBook(int)
    }
}