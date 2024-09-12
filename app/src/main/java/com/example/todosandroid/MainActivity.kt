package com.example.todosandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Todo("Einkaufen")
        }
    }
}

@Composable
fun Todo(name: String) {
    Row {
        Checkbox(checked = false, onCheckedChange = { })
        Text(name)
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "Todo Vorschau"
)
@Composable
fun TodoPreview() {
    Todo("Sport machen")
}