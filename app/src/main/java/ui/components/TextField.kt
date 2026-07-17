package ui.components

import android.R.attr.value
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun TextFieldFunction(
    text: String,
    onTextChange:(String) -> Unit,
    label:String
) {

    TextField(
       value = text,
        onValueChange = {onTextChange(it)},
        label = {Text(text = text)}
    )
}
