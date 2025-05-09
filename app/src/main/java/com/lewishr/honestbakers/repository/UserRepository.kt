package com.lewishr.honestbakers.repository

import com.lewishr.honestbakers.data.UserDao
import com.lewishr.honestbakers.model.User


class UserRepository(private val userDao: UserDao) {
    suspend fun registerUser(user: User) {
        userDao.registerUser(user)
    }

    suspend fun loginUser(email: String, password: String): User? {
        return userDao.loginUser(email, password)
    }
}