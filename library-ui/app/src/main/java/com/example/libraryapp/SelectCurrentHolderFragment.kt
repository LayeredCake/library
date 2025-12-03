package com.example.libraryapp

class SelectCurrentHolderFragment: SelectUserFragment() {
    override fun callback(user: User): Unit {
        viewModel?.currentHolder?.value = user
    }
}