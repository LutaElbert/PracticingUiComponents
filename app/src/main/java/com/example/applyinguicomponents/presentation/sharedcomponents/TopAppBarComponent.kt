package com.example.applyinguicomponents.presentation.sharedcomponents

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarComponent(
    onClickDrawerIcon: () -> Unit,
    onSwitchChecked: () -> Unit
) {
    var isDropdownExpanded by rememberSaveable { mutableStateOf(false) }
    var isModeSwitchSelected by rememberSaveable { mutableStateOf(false) }

    CenterAlignedTopAppBar(
        title = { Text("Test Ui Components") },
        navigationIcon = {
            IconButton(
                onClick = {
                    onClickDrawerIcon.invoke()
                }
            ) {
                Icon(Icons.Default.Menu, contentDescription = "Menu")
            }
        },
        actions = {
            Icon(
                modifier = Modifier
                    .clickable {
                        isDropdownExpanded = true
                    },
                imageVector = Icons.Default.MoreVert,
                contentDescription = ""
            )

            DropdownMenu(
                expanded = isDropdownExpanded,
                onDismissRequest = {
                    isDropdownExpanded = false
                }
            ) {
                DropdownMenuItem(
                    text = { Text("Theme") },
                    onClick = { onSwitchChecked.invoke() },
                    trailingIcon = {
                        Switch(
                            checked = isModeSwitchSelected,
                            onCheckedChange = {
                                isModeSwitchSelected = it
                                onSwitchChecked.invoke()
                            },
                            thumbContent = {
                                if (isModeSwitchSelected)
                                    Icon(
                                        Icons.Filled.DarkMode,
                                        contentDescription = "Dark Mode"
                                    )
                                else Icon(
                                    Icons.Filled.LightMode,
                                    contentDescription = "Light Mode"
                                )
                            },
                            colors = SwitchDefaults.colors(
                                uncheckedThumbColor = MaterialTheme.colorScheme.secondary,
                                uncheckedTrackColor = MaterialTheme.colorScheme.secondaryContainer,
                            )
                        )
                    }
                )
            }
        }
    )
}
