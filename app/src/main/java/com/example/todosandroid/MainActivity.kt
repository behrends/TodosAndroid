package com.example.todosandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
fun Todo(text: String) {
    Text(text)
}

@Preview
@Composable
fun TodoPreview() {
    Todo("Sport machen")
}