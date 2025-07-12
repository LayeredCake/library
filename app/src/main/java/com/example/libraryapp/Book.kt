package com.example.libraryapp

data class Book(
    var title: String,
    var author: String,
    var series: String,
    var pageCount: Int,
    var owner: String,
    var genre: Int,
    var currentHolder: String,
    var condition: Int,
    var format: Int,
    var id: Int?
){

}
