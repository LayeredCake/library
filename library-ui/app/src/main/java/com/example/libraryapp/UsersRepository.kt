package com.example.libraryapp

class UsersRepository(private val userDataSource: UserDataSource) {

    suspend fun getUserList(): Array<User> {
        return userDataSource.getUsers()
    }

    suspend fun getUser(id: Int): User {
        return userDataSource.getUser(id)
    }

    suspend fun updateUser(int: Int, user: User) {
        userDataSource.updateUser(int, user)
    }

    suspend fun newUser(user: User) {
        userDataSource.newUser(user)
    }

    suspend fun delUser(int: Int) {
        userDataSource.delUser(int)
    }
}