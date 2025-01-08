package com.example.quicksos.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) { /*TODO*/ }
        composable(Screen.EmergencyContacts.route) { /*TODO*/ }
        composable(Screen.Location.route) { /*TODO*/ }
        composable(Screen.Settings.route) { /*TODO*/ }
    }
}