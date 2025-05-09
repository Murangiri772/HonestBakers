package com.lewishr.honestbakers.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lewishr.honestbakers.model.User
import com.lewishr.honestbakers.repository.UserRepository

import kotlinx.coroutines.launch

class AuthViewModel(private val repository: UserRepository) : ViewModel() {
    var loggedInUser: ((User?) -> Unit)? = null

    fun registerUser(user: User) {
        viewModelScope.launch {
            repository.registerUser(user)
        }
    }

    fun loginUser(email: String, password: String) {
        viewModelScope.launch {
            val user = repository.loginUser(email, password)
            loggedInUser?.invoke(user)
        }
    }
}