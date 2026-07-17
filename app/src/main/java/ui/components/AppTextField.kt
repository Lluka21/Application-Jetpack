package ui.components

import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable

@Composable
fun TextFieldFunction(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
) {

    TextField(
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(text = label)
        }
    )
}
