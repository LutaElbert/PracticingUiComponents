package com.example.applyinguicomponents.presentation.util.sharedcomponents

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.applyinguicomponents.presentation.util.navigation.MainDestinations
import com.example.applyinguicomponents.presentation.util.navigation.MainScreens
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldComponents(content: @Composable (PaddingValues, NavHostController) -> Unit) {
    var drawerState = rememberDrawerState(DrawerValue.Closed)
    val navController = rememberNavController()
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerContent { drawerItem ->
                when(drawerItem) {
                    MainScreens.HOME.capitalized() -> navController.navigate(
                        MainDestinations.DashboardScreen
                    )
                    MainScreens.CALENDAR.capitalized() -> navController.navigate(
                        MainDestinations.CalendarScreen
                    )
                    MainScreens.NOTIFICATIONS.capitalized() -> navController.navigate(
                        MainDestinations.NotificationScreen
                        )
                    MainScreens.PROFILE.capitalized() -> navController.navigate(
                        MainDestinations.ProfileScreen
                    )
                    MainScreens.SETTINGS.capitalized() -> navController.navigate(
                        MainDestinations.SettingScreen
                    )
                    MainScreens.HELP.capitalized() -> navController.navigate(
                        MainDestinations.HelpScreen
                    )
                    MainScreens.LOGOUT.capitalized() -> navController.navigate(
                        MainDestinations.DashboardScreen
                    )
                }
                scope.launch {
                    drawerState.close()
                }
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBarComponent(
                    onClickDrawerIcon = {
                        scope.launch {
                            if (drawerState.isClosed) drawerState.open()
                            else drawerState.close()
                        }
                    },
                    onSwitchChecked = {}
                )
            },
            bottomBar = {
                BottomAppBarComponent { route ->
                    when (route) {
                        MainScreens.HOME.capitalized() -> navController.navigate(
                            MainDestinations.DashboardScreen
                        )
                        MainScreens.CALENDAR.capitalized() -> navController.navigate(
                            MainDestinations.CalendarScreen
                        )
                        MainScreens.NOTIFICATIONS.capitalized() -> navController.navigate(
                            MainDestinations.NotificationScreen
                        )
                        MainScreens.PROFILE.capitalized() -> navController.navigate(
                            MainDestinations.ProfileScreen
                        )
                    }
                }
            }
        ) {
            content.invoke(it, navController)
        }
    }
}

fun NavHostController.navigate(screen: MainScreens) {

}

data class DrawerItem(val name: String, val icon: ImageVector)
