package com.example.libraryapp

class SelectOwnerFragment: SelectUserFragment() {
    override fun callback(user: User): Unit {
        viewModel?.owner?.value = user
    }
}