package com.example.quicksos.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quicksos.ui.screens.EmergencyContactScreen
import com.example.quicksos.ui.screens.LocationScreen
import com.example.quicksos.ui.screens.SOSHomeScreen
import com.example.quicksos.ui.screens.SettingScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) { SOSHomeScreen() }
        composable(Screen.EmergencyContacts.route) { EmergencyContactScreen() }
        composable(Screen.Location.route) { LocationScreen() }
        composable(Screen.Settings.route) { SettingScreen() }
    }
}