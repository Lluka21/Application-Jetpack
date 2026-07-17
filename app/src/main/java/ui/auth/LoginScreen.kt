package ui.auth

import android.R.attr.label
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import ui.components.TextFieldFunction


@Composable

fun LoginScreen(
    navController: NavController,
    authViewModel: AuthViewModel = viewModel()
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ){
        Text(
            text = "Login",
            fontSize = 30.sp,
            color = Color(0xFF888888)
        )
        TextFieldFunction(
            value = authViewModel.email,
            onValueChange = {
                authViewModel.onEmailChange(it)
            },
            label = "Email"
        )
        TextFieldFunction(
            value = authViewModel.email,
            onValueChange = {
                authViewModel.onEmailChange(it)
            },
            label = "Email"
        )


//        Button(onClick = {
//            navController.navigate("home")
//        }){
//            Text(text="Main Screen")
//        }
    }


}
