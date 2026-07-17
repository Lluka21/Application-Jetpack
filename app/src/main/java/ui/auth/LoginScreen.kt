package ui.auth

import android.R.attr.label
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import ui.components.TextFieldFunction


@Composable

fun LoginScreen(
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
        TextFieldFunction(
            value = authViewModel.email,
            onValueChange = {
                authViewModel.onEmailChange(it)
            },
            label = "Email"

        )
        Spacer(modifier = Modifier.height(10.dp))
        TextFieldFunction(
            value = authViewModel.password,
            onValueChange = {
                authViewModel.onEmailChange(it)
            },
            label = "Password"
        )

    }


}


