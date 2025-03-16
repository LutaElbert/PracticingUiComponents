package com.example.applyinguicomponents.presentation.dashboard

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun DashboardScreen(
    onClick: () -> Unit
) {
    Column {
        Text("Dashboard Screen")

        Button(onClick = {
            onClick.invoke()
        },) {
            Text("Details Screen")
        }
    }
}