package com.example.todosandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.todosandroid.data.AppDatabase
import com.example.todosandroid.data.TodoDao
import com.example.todosandroid.ui.HomeScreen
import com.example.todosandroid.ui.SettingsScreen
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
            val navController = rememberNavController()
            TodosAndroidTheme {
                Scaffold(bottomBar = {
                    BottomAppBar(actions = {
                        IconButton(onClick = {}) {
                            Icon(Icons.Filled.Home, contentDescription = "Todos")
                        }
                        IconButton(onClick = {}) {
                            Icon(
                                Icons.Filled.Settings,
                                contentDescription = "Einstellungen",
                            )
                        }
                    })
                }) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "home",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable("home") {
                            HomeScreen(todoDao)
                        }
                        composable("settings") {
                            SettingsScreen()
                        }
                    }
                }
            }
        }
    }
}