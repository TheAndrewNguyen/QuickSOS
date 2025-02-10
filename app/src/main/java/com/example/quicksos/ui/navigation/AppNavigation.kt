package com.example.quicksos.ui.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quicksos.ui.screens.emergencyContacts.EmergencyContactScreen
import com.example.quicksos.ui.screens.home.SOSHomeScreen
import com.example.quicksos.ui.screens.location.LocationScreen
import com.example.quicksos.ui.screens.settings.SettingsScreen

@Composable
fun AppNavigation(modifier: Modifier) {
    val navController = rememberNavController()

    Box(modifier = modifier) {
        NavHost(navController = navController, startDestination = Screen.Home.route) {
            composable(Screen.Home.route) {
                SOSHomeScreen(navController)
            }
            composable(Screen.EmergencyContacts.route) {
                EmergencyContactScreen(navController)
            }
            composable(Screen.Location.route) { LocationScreen(navController) }
            composable(Screen.Settings.route) { SettingsScreen() }
        }
    }
}