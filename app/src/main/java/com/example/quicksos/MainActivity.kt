package com.example.quicksos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quicksos.ui.screens.EmergencyContactScreen
import com.example.quicksos.ui.screens.SOSHomeScreen
import com.example.quicksos.ui.theme.QuickSOSTheme

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            SOSHomeScreen()
        }
        composable("emergencyContacts") {
            EmergencyContactScreen()
        }
    }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            QuickSOSTheme(dynamicColor = false) {
                Navigation()
            }
        }
    }
}
