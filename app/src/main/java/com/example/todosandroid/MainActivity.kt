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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Checkbox
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todosandroid.ui.theme.TodosAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TodosAndroidTheme {
                Scaffold(floatingActionButton = {
                    FloatingActionButton(onClick = {},
                        content = { Icon(Icons.Filled.Add, contentDescription = "Todo erstellen") })
                }) { innerPadding ->
                    TodoList(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun TodoList(modifier: Modifier = Modifier) {
    val todos = listOf("Einkaufen", "Android lernen", "Sport machen")
    Column(modifier) {
        for (todo in todos) {
            Todo(todo)
        }
    }
}

@Composable
fun Todo(name: String) {
    var done by remember { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .clickable(onClick = { done = !done })
            .padding(10.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(checked = done, onCheckedChange = { done = it })
        Text(name, fontWeight = FontWeight.Bold, fontSize = 22.sp)
    }
}

@Preview(
    showBackground = true, showSystemUi = true, name = "Todo Vorschau"
)
@Composable
fun TodoPreview() {
    Todo("Sport machen")
}