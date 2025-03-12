package com.example.applyinguicomponents.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.applyinguicomponents.presentation.DashboardScreen
import com.example.applyinguicomponents.presentation.DetailsScreen
import kotlinx.serialization.Serializable

typealias dashboard = MainDestinations.DashboardScreen
typealias detail = MainDestinations.DetailScreen

@Composable
fun MainNavHost(paddingValues: PaddingValues) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = dashboard) {
        composable<dashboard> {
            DashboardScreen(modifier = Modifier.padding(paddingValues)) {
                navController.navigate(detail)
            }
        }
        composable<detail> {
            DetailsScreen(modifier = Modifier.padding(paddingValues))
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
    LOGOUT
}

sealed class MainDestinations {
    @Serializable
    data object DashboardScreen: MainDestinations()

    @Serializable
    data object DetailScreen: MainDestinations()
}
