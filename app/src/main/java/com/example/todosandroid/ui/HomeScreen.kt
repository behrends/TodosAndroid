package com.example.todosandroid.ui

import AddTodoDialog
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Checkbox
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todosandroid.data.TodoDao
import com.example.todosandroid.data.TodoItem
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(todoDao: TodoDao) {
    val todos by todoDao.getAllTodos().collectAsState(initial = emptyList())
    var showDialog by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { showDialog = true },
                content = {
                    Icon(Icons.Filled.Add, contentDescription = "Todo erstellen")
                }
            )
        }
    ) { innerPadding ->
        if (showDialog) {
            AddTodoDialog(
                onDismiss = { showDialog = false },
                onAdd = { newTodo ->
                    coroutineScope.launch {
                        todoDao.insertTodo(TodoItem(name = newTodo))
                    }
                    showDialog = false
                }
            )
        }
        TodoList(
            todos = todos,
            todoDao = todoDao,
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun TodoList(todos: List<TodoItem>, todoDao: TodoDao, modifier: Modifier = Modifier) {
    LazyColumn(modifier) {
        items(todos) { todo ->
            Todo(todo = todo, todoDao = todoDao)
        }
    }
}

@Composable
fun Todo(todo: TodoItem, todoDao: TodoDao) {
    val coroutineScope = rememberCoroutineScope()
    var done by remember { mutableStateOf(todo.done) }
    Row(
        modifier = Modifier
            .clickable(onClick = {
                done = !done
                // Status in der Datenbank aktualisieren
                coroutineScope.launch {
                    todoDao.updateTodo(todo.copy(done = done))
                }
            })
            .padding(10.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(checked = done, onCheckedChange = {
            done = it
            // Status in der Datenbank aktualisieren
            coroutineScope.launch {
                todoDao.updateTodo(todo.copy(done = done))
            }
        })
        Text(todo.name, fontWeight = FontWeight.Bold, fontSize = 22.sp)
    }
}
