package com.example.libraryapp
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class User(
    var username: String,
    var password: String,
    var id: Int?
): Parcelable {}