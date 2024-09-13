package com.example.todosandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoList()
        }
    }
}

@Composable
fun TodoList() {
    Column {
        Todo("Einkaufen")
        Todo("Android lernen")
        Todo("Sport machen")
    }
}

@Composable
fun Todo(name: String) {
    Row {
        Checkbox(checked = false, onCheckedChange = { })
        Text(name, fontWeight = FontWeight.Bold, fontSize = 22.sp)
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