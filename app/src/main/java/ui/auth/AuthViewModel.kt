package ui.auth

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import data.model.SignUpRequest
import com.example.myapplication.data.repository.AuthRepository




class AuthViewModel(private val repository: AuthRepository) : ViewModel() {

    var email by mutableStateOf("")
        private set

    var password by mutableStateOf("")
        private set

    var username by mutableStateOf("")
        private set

    var confirmPassword by mutableStateOf("")
        private set

    fun onEmailChange(newEmail: String) {
        email = newEmail
    }

    fun onPasswordChange(newPassword: String) {
        password = newPassword
    }

    fun onUsernameChange(newUsername: String) {
        username = newUsername
    }

    fun onConfirmPassword(newConfirmPassword: String) {
        confirmPassword = newConfirmPassword
    }

    suspend fun signup()  {
      val signUpData =   SignUpRequest(
            username = username,
            email = email,
            password = password,
        )

        repository.signup(signUpData);
    }



}




