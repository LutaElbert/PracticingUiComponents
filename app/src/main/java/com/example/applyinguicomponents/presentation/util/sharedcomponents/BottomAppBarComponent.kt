package com.example.applyinguicomponents.presentation.util.sharedcomponents

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.example.applyinguicomponents.presentation.util.navigation.MainScreens

@Composable
fun BottomAppBarComponent(onClick: (String) -> Unit) {
    val drawerItems = listOf(
        DrawerItem(MainScreens.HOME.capitalized(), Icons.Default.Home),
        DrawerItem(MainScreens.CALENDAR.capitalized(), Icons.Default.CalendarMonth),
        DrawerItem(MainScreens.NOTIFICATIONS.capitalized(), Icons.Default.Notifications),
        DrawerItem(MainScreens.PROFILE.capitalized(), Icons.Default.Person),
    )

    var selectedItem by rememberSaveable { mutableStateOf(false) }

    NavigationBar {
        drawerItems.mapIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItem,
                label = { Text(item.name, style = MaterialTheme.typography.titleSmall) },
                onClick = {
                    onClick.invoke(item.name)
                },
                icon = {
                    BadgedBox(
                        badge = {
                            if (item.name == MainScreens.NOTIFICATIONS.capitalized())
                                Badge {
                                    Text("10", style = MaterialTheme.typography.titleSmall)
                                }
                        }
                    ) {
                        Icon(item.icon, contentDescription = "")
                    }
                }
            )
        }
    }
}