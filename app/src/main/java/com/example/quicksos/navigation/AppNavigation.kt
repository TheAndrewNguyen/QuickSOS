package com.example.quicksos.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quicksos.ui.screens.emergencyContacts.EmergencyContactScreen
import com.example.quicksos.ui.screens.home.SOSHomeScreen
import com.example.quicksos.ui.screens.location.LocationScreen
import com.example.quicksos.ui.screens.settings.SettingsScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) { SOSHomeScreen(navController) }
        composable(Screen.EmergencyContacts.route) { EmergencyContactScreen(navController) }
        composable(Screen.Location.route) { LocationScreen(navController) }
        composable(Screen.Settings.route) { SettingsScreen(navController) }
    }

}

fun navigateTo(navController: NavController, route: String) {
    navController.navigate(route) {
        navController.navigate(route)
    }
}

