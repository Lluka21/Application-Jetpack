package ui.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ui.auth.AuthViewModel
import ui.auth.LoginScreen
import ui.auth.SignUp
import ui.screens.HelloUser
import ui.screens.WelcomeScreen
import com.example.myapplication.data.repository.AuthRepository
import com.example.myapplication.data.remote.RetrofitInstance

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val repository = AuthRepository(RetrofitInstance.authApi)


    NavHost(
        navController = navController, startDestination = "welcome"
    ) {
        composable("welcome") {
            WelcomeScreen(navController)
        }
        composable("login"){
            LoginScreen(navController, repository = repository)
        }
        composable("sign up") {
            SignUp(navController, repository = repository)
        }
    }
}