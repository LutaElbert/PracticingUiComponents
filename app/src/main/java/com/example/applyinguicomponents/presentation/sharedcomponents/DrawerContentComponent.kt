package com.example.applyinguicomponents.presentation.sharedcomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Help
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.applyinguicomponents.presentation.navigation.MainScreens
import com.example.applyinguicomponents.util.extension.toCapitalizeString

@Composable
fun DrawerContent(selectedItem: DrawerItem?, onClick: () -> Unit) {
    val drawerItems = listOf(
        DrawerItem(MainScreens.HOME.name.toCapitalizeString(), Icons.Default.Home),
        DrawerItem(MainScreens.PROFILE.name.toCapitalizeString(), Icons.Default.Person),
        DrawerItem(MainScreens.NOTIFICATIONS.name.toCapitalizeString(), Icons.Default.Notifications),
        DrawerItem(MainScreens.SETTINGS.name.toCapitalizeString(), Icons.Default.Settings),
        DrawerItem(MainScreens.HELP.name.toCapitalizeString(), Icons.AutoMirrored.Filled.Help),
        DrawerItem(MainScreens.LOGOUT.name.toCapitalizeString(), Icons.AutoMirrored.Filled.Logout),
    )

    ModalDrawerSheet {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            drawerItems.forEachIndexed { index, item ->
                if (index == 3) {
                    Spacer(Modifier.weight(1f))
                }
                NavigationDrawerItem(
                    label = { Text(text = item.name, style = MaterialTheme.typography.titleSmall) },
                    selected = item == selectedItem,
                    icon = {
                        Icon(item.icon, contentDescription = "menu_icon")
                    },
                    badge = {
                        if (item.name == "Notifications") {
                            Badge {
                                Text(
                                    modifier = Modifier.padding(4.dp),
                                    text = "10",
                                    style = MaterialTheme.typography.titleSmall
                                )
                            }
                        }
                    },
                    onClick = { onClick.invoke() }
                )
            }
        }
    }
}