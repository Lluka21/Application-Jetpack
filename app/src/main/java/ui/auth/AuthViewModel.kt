package ui.auth

//import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import data.model.SignUpRequest
import com.example.myapplication.data.repository.AuthRepository
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import error.AuthError
import retrofit2.HttpException
class AuthViewModel(private val repository: AuthRepository) : ViewModel(){

    var error by mutableStateOf<AuthError?>(null)

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
                try {
                    repository.signup(signUpData)
                } catch(e: HttpException) {
                    if(e.code() == 400) {
                        error = AuthError.Validation("All fields are required")
                    }
                }

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



