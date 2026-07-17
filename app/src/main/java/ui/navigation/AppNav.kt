package ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ui.auth.LoginScreen
import ui.screens.HelloUser
import ui.screens.WelcomeScreen


@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController, startDestination = "welcome"
    ) {
        composable("welcome") {
            WelcomeScreen(navController)
        }
        composable("login"){
            LoginScreen(navController)
        }
        composable("home") {
            HelloUser()
        }
    }
}