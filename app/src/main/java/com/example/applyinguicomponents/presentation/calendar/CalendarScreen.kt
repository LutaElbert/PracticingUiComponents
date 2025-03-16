package com.example.applyinguicomponents.presentation.calendar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalendarScreen() {
    val datePickerState = rememberDatePickerState(initialDisplayMode = DisplayMode.Picker)
    Column {
        DatePicker(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth(),
            state = datePickerState,
            showModeToggle = false
        )
        Text("Selected date timestamp: ${datePickerState.selectedDateMillis}")
    }
}