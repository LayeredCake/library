package com.example.libraryapp


class UserDataSource(
    private val api: APIInterface,
) {

    suspend fun getUsers(): Array<User> {
        return api.getUsers()
    }

    suspend fun getUser(id: Int): User {
        return api.getUser(id)
    }

    suspend fun updateUser(id: Int, user: User) {
        api.putUser(id, user)
    }

    suspend fun newUser(user: User) {
        api.postUser(user)
    }

    suspend fun delUser(id: Int) {
        api.delUser(id)
    }

}
