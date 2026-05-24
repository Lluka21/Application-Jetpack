package com.example.myapplication

import android.R.attr.paddingTop
import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {

                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "login"
                ){
                    composable("login"){
                        LoginScreen(navController)
                    }
                    composable("forgot_password") {
                        ForgotPasswordScreen()
                    }
                    composable("sign_in") {
                        SignInScreen()
                    }
                }


            }

        }
    }
}

@Composable
fun LoginScreen(navController: NavController) {
    val view = LocalView.current

    SideEffect {
        val window = (view.context as Activity).window
        WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = true
    }

    var text by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }


    Box(modifier = Modifier.fillMaxSize()) {


        Text(
            "Sign In",
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(50.dp)
                .clickable{
                    navController.navigate("sign_in")
                }

        )
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Sign In SpeechLab", fontSize = 30.sp)
            Spacer(Modifier.height(30.dp))
            Column() {
                Text("Email Address")
                Spacer(Modifier.height(15.dp))
                TextField(
                    value = text,
                    onValueChange = { text = it },
                    placeholder = { Text("Enter your email") },
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Gray,
                        unfocusedContainerColor = Color.Gray,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        errorIndicatorColor = Color.Transparent),
                    modifier = Modifier.width(350.dp),
                    shape = RoundedCornerShape(12.dp)
                )

            }
            Spacer(Modifier.height(12.dp))
            Column() {
                Text("Password")
                Spacer(Modifier.height(15.dp))
                TextField(
                    value = password,
                    onValueChange = { password = it },
                    placeholder = { Text("Enter your password") },
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Gray,
                        unfocusedContainerColor = Color.Gray,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        errorIndicatorColor = Color.Transparent),
                    modifier = Modifier.width(350.dp),
                    shape = RoundedCornerShape(12.dp)
                )
            }

            Spacer(Modifier.height(12.dp))
            Row(
                modifier = Modifier.width(350.dp),
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    "Forgot Password",
                    modifier = Modifier.clickable{
                        navController.navigate("forgot_password")
                    }

                )
            }
            Spacer(Modifier.height(12.dp))
            Button(onClick = {},
                    modifier = Modifier.width(350.dp)
                        .height(50.dp),
                            colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFFFD700),
                contentColor = Color.Black
            )
                ) {
                Text("Login")
            }
        }

    }


}