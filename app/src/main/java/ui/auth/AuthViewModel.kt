package ui.auth

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import data.model.SignUpRequest
import com.example.myapplication.data.repository.AuthRepository
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class AuthViewModel(private val repository: AuthRepository) : ViewModel(){

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

    fun signup() {
        if (confirmPassword == password) {
            viewModelScope.launch {
                val signUpData = SignUpRequest(
                    username = username,
                    password = password,
                    email = email
                )
//                repository.signup(signUpData)
            }
        } else {
            throw IllegalArgumentException("Passwords don't match!") // We can change this with UI
        }
    }


}



class AuthViewModelFactory(private val repository: AuthRepository) : ViewModelProvider.Factory{

     override fun <T: ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(AuthViewModel::class.java)) {
            return AuthViewModel(repository) as T
        } else {
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }


}



