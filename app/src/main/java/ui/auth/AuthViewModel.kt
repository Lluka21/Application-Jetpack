package ui.auth

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class AuthViewModel : ViewModel() {

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



//    fun login() {
//
//    }

}


