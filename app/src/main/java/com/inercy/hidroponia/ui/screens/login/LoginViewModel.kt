package com.inercy.hidroponia.ui.screens.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class LoginViewModel() : ViewModel() {
    private val auth = FirebaseAuth.getInstance()

    private val _authState = MutableLiveData<AuthState>()
    val authState: LiveData<AuthState> = _authState

    var userInput by mutableStateOf("")
        private set
    var passwordInput by mutableStateOf("")
        private set
    var isPasswordVisible by mutableStateOf(false)
        private set

    init {
        checkAuthStatus()
    }

    fun updateUser(user: String) {
        userInput = user
    }

    fun updatePassword(password: String) {
        passwordInput = password
    }

    fun togglePasswordVisibility() {
        isPasswordVisible = !isPasswordVisible
    }

    fun checkAuthStatus() {
        if (auth.currentUser != null) {
            _authState.value = AuthState.Authenticated
        } else {
            _authState.value = AuthState.Unauthenticated
        }
    }

    fun login() {
        if (userInput.isEmpty() || passwordInput.isEmpty()) {
            _authState.value = AuthState.Error("Por favor, ingrese un correo electrónico y una contraseña válidos.")
            return
        }

        _authState.value = AuthState.Loading
        auth.signInWithEmailAndPassword(userInput, passwordInput)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    _authState.value = AuthState.Authenticated
                } else {
                    _authState.value = AuthState.Error(task.exception?.message ?: "Ocurrio un error al iniciar sesión")
                }
            }
    }

    fun signOut() {
        auth.signOut()
        _authState.value = AuthState.Unauthenticated
    }
}

sealed class AuthState {
    object Authenticated : AuthState()
    object Unauthenticated : AuthState()
    object Loading : AuthState()
    data class Error(val message: String) : AuthState()
}