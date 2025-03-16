package com.example.applyinguicomponents.presentation.util.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.applyinguicomponents.presentation.calendar.CalendarScreen
import com.example.applyinguicomponents.presentation.dashboard.DashboardScreen
import com.example.applyinguicomponents.presentation.detail.DetailsScreen
import com.example.applyinguicomponents.presentation.help.HelpScreen
import com.example.applyinguicomponents.presentation.notification.NotificationScreen
import com.example.applyinguicomponents.presentation.profile.ProfileScreen
import com.example.applyinguicomponents.presentation.setting.SettingScreen
import com.example.applyinguicomponents.util.extension.toCapitalizeString
import kotlinx.serialization.Serializable

typealias dashboard = MainDestinations.DashboardScreen
typealias detail = MainDestinations.DetailScreen
typealias calendar = MainDestinations.CalendarScreen
typealias help = MainDestinations.HelpScreen
typealias notification = MainDestinations.NotificationScreen
typealias profile = MainDestinations.ProfileScreen
typealias setting = MainDestinations.SettingScreen

@Composable
fun MainNavHost(paddingValues: PaddingValues, navController: NavHostController) {
    NavHost(navController = navController, startDestination = dashboard, modifier = Modifier.padding(paddingValues)) {
        composable<dashboard> {
            DashboardScreen {
                navController.navigate(detail)
            }
        }
        composable<detail> {
            DetailsScreen()
        }
        composable<calendar> {
            CalendarScreen()
        }
        composable<help> {
            HelpScreen()
        }
        composable<notification> {
            NotificationScreen()
        }
        composable<profile> {
            ProfileScreen()
        }
        composable<setting> {
            SettingScreen()
        }
    }
}

enum class MainScreens() {
    HOME,
    CALENDAR,
    DETAILS,
    NOTIFICATIONS,
    PROFILE,
    SETTINGS,
    HELP,
    LOGOUT;

    fun capitalized(): String {
        return when (this) {
            HOME -> this.name.toCapitalizeString()
            CALENDAR -> this.name.toCapitalizeString()
            DETAILS -> this.name.toCapitalizeString()
            NOTIFICATIONS -> this.name.toCapitalizeString()
            PROFILE -> this.name.toCapitalizeString()
            SETTINGS -> this.name.toCapitalizeString()
            HELP -> this.name.toCapitalizeString()
            LOGOUT -> this.name.toCapitalizeString()
        }
    }
}

sealed class MainDestinations() {
    @Serializable
    data object DashboardScreen: MainDestinations()

    @Serializable
    data object DetailScreen: MainDestinations()

    @Serializable
    data object CalendarScreen: MainDestinations()

    @Serializable
    data object HelpScreen: MainDestinations()

    @Serializable
    data object NotificationScreen: MainDestinations()

    @Serializable
    data object ProfileScreen: MainDestinations()

    @Serializable
    data object SettingScreen: MainDestinations()
}
