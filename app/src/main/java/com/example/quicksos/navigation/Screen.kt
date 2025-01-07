package com.example.quicksos.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object EmergencyContacts : Screen("emergencyContacts")
    object Location : Screen("location")
    object Settings : Screen("settings")
}