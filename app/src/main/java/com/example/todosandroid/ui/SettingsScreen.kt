package com.example.todosandroid.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun SettingsScreen() {
    Text(
        text = "Einstellungen",
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center),
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
    )
}
