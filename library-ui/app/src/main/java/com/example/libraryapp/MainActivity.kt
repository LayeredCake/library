package com.example.libraryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    val api: APIInterface = APIClient().getRetrofitClient().create(APIInterface::class.java)

    val booksRepository: BooksRepository = BooksRepository(BookDataSource(api))
    val usersRepository: UsersRepository = UsersRepository(UserDataSource(api))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}