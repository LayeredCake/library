package com.example.libraryapp


class BookDataSource(
    private val api: APIInterface,
) {


    suspend fun getBooks(): Array<Book> {
        return api.getBooks()
    }

    suspend fun getBook(id: Int): Book {
        return api.getBook(id)
    }

    suspend fun updateBook(id: Int, book: Book) {
        api.putBook(id, book)
    }

    suspend fun newBook(book: Book) {
        api.postBook(book)
    }


    suspend fun delBook(id: Int) {
        api.delBook(id)
    }

}
