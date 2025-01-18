package com.example.libraryapp

import java.sql.Connection
import java.sql.DriverManager
import kotlin.concurrent.thread

data class BookData(val id: Int, val title: String, val author: String)

class Database {
    private val host = "10.0.2.2"
    private val database = "library"
    private val port = 5432
    private val user = "postgres"
    private val pass = "password"
    private var url = "jdbc:postgresql://%s:%d/%s"
    private var status = false

    constructor() {
        this.url = String.format(this.url, this.host, this.port, this.database)
        connect()
    }

    private fun connect() {
        try {

            val connection = DriverManager
                .getConnection(url, this.user, this.pass)
        } catch( e: Exception) {
            println(e.message)
        }

        // prints true if the connection is valid
        //println(connection.isValid(0))

        //query(connection)

    }

    fun query(connection: Connection) {
        // the query is only prepared not executed
        val query = connection.prepareStatement("SELECT * FROM books")

        // the query is executed and results are fetched
        val result = query.executeQuery()

        // an empty list for holding the results
        val books = mutableListOf<BookData>()

        while(result.next()){

            // getting the value of the id column
            val id = result.getInt("id")

            // getting the value of the title column
            val title = result.getString("title")

            val author = result.getString("author")


            /*
            constructing a User object and
            putting data into the list
             */
            books.add(BookData(id, title, author))
        }

        println(books)
    }
}