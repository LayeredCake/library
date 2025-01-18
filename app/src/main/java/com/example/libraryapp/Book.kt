package com.example.libraryapp

data class Book(
    var title: String,
    var author: String,
    var series: String,
    var pageCount: Int,
    var owner: String,
    var genre: String,
    var currentHolder: String,
    var condition: String,
    var format: String,
    var id: Int?
){

}
