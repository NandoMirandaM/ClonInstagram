package com.nandomdev.instaclon.view.auth.login

import android.util.Patterns
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel : ViewModel() {
    private val _uiSate = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiSate

    fun onEmailChanged(email: String) {
        _uiSate.update {
            //_uiSate.value.copy(email = email)
            it.copy(email = email)
        }
        verifyLogin()
    }

    fun onPasswordChanged(password: String) {
        _uiSate.update {
            it.copy(password = password)
        }
        verifyLogin()
    }

    private fun verifyLogin() {
        val enabledLogin =
            isEmailValid(_uiSate.value.email) && isPasswordValid(_uiSate.value.password)
        _uiSate.update {
            it.copy(isLoginEnabled = enabledLogin)
        }
    }

    fun isEmailValid(email: String): Boolean = Patterns.EMAIL_ADDRESS.matcher(email).matches()

    fun isPasswordValid(password: String): Boolean = password.length >= 6
}