package com.example.myapplication

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat


class MainActivity :    ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                LoginScreen()
            }

        }
    }
}

@Composable
fun LoginScreen(){
    val view = LocalView.current

    SideEffect {
        val window = (view.context as Activity).window
        WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = true
    }

    var text by remember { mutableStateOf("")}
    var password by remember { mutableStateOf("")}

    Column(
        modifier = Modifier.fillMaxSize(),
        Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text("Sign In SpeechLab", fontSize = 30.sp)
        Spacer(Modifier.height(12.dp),)
        Column(){
            Text("Email Address")
            Spacer(Modifier.height(8.dp),)
            TextField(
                value = text,
                onValueChange = {text = it},
                placeholder = {Text( "Enter your email")},
                modifier = Modifier.width(350.dp)
            )
        }

        Spacer(Modifier.height(12.dp),)
        Column(){
            Text("Password")
            Spacer(Modifier.height(8.dp),)
            TextField(
                value = password,
                onValueChange = {password = it},
                placeholder = {Text( "Enter your password")},
                modifier = Modifier.width(350.dp)
            )
        }

        Spacer(Modifier.height(12.dp),)
        Text("Forgot Password?")
        Button(onClick={}) {
            Text("Login")
        }
    }





}