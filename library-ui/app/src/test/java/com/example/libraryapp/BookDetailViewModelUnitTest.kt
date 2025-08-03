package com.example.libraryapp

import java.lang.Class
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock

@RunWith(MockitoJUnitRunner::class)
class BookDetailViewModelUnitTest {

    @Mock
    private lateinit var mockRepository: BooksRepository


    @Test
    fun testViewModelFactory() {
        val mockRepository = mock<BooksRepository> {

        }

        var bookDetailViewModelFactory: BookDetailViewModelFactory = BookDetailViewModelFactory(mockRepository, 1)

        //var bookDetailViewModel: BookDetailViewModel = bookDetailViewModelFactory.create()
    }

    @Test
    fun testGetBook() {

    }
}