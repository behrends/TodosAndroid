package com.example.todosandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.room.Room
import com.example.todosandroid.data.AppDatabase
import com.example.todosandroid.data.TodoDao
import com.example.todosandroid.ui.HomeScreen
import com.example.todosandroid.ui.theme.TodosAndroidTheme

class MainActivity : ComponentActivity() {
    private lateinit var database: AppDatabase
    private lateinit var todoDao: TodoDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Datenbank erstellen
        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "todo-database"
        ).build()
        todoDao = database.todoDao()

        enableEdgeToEdge()
        setContent {
            TodosAndroidTheme {
                HomeScreen(todoDao = todoDao)
            }
        }
    }
}