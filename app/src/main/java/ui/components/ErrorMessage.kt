package ui.components

import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable


@Composable
fun ErrorMessage(message: String) {
    Snackbar{
        Text(text = message )
    }
}