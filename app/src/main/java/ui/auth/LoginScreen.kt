package ui.auth

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import ui.components.AppTextField


@Composable

fun LoginScreen(
    navController: NavController,
    authViewModel: AuthViewModel = viewModel()

) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 14.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ){
        Text(
            text = "Login",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF000000)
        )
        Spacer(modifier = Modifier.height(30.dp))
        AppTextField(
            value = authViewModel.email,
            onValueChange = {
                authViewModel.onEmailChange(it)
            },
            label = "Email"

        )
        Spacer(modifier = Modifier.height(10.dp))
        AppTextField(
            value = authViewModel.password,
            onValueChange = {
                authViewModel.onEmailChange(it)
            },
            label = "Password"
        )
        Row(
            modifier = Modifier
            .padding(35.dp)
        ){
            Text(
                text = "Don't have an account ?",
                modifier = Modifier.padding(end = 7.dp)
            )
            Text(
                text = "Sign Up",
                modifier = Modifier.clickable{
                    navController.navigate("sign up")
                }
            )
        }


    }


}


