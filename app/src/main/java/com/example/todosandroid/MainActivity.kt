package com.example.todosandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold() { innerPadding ->
                TodoList(modifier = Modifier.padding(innerPadding))
            }
        }
    }
}

@Composable
fun TodoList(modifier: Modifier = Modifier) {
    Column(modifier) {
        Todo("Einkaufen")
        Todo("Android lernen")
        Todo("Sport machen")
    }
}

@Composable
fun Todo(name: String) {
    Row(
        modifier = Modifier
            .clickable(onClick = {})
            .padding(10.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
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