package com.example.quicksos.ui.navigation

import android.util.Log
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.quicksos.ui.theme.QuickSOSTheme

//items for NavBar
val items = listOf("Action", "Location", "Emergency Contacts", "Settings")
val selectedIcons = listOf(
    Icons.Filled.Home,
    Icons.Filled.LocationOn,
    Icons.Filled.AccountBox,
    Icons.Filled.Settings
)

val unselectedIcons = listOf(
    Icons.Outlined.Home,
    Icons.Outlined.LocationOn,
    Icons.Outlined.AccountBox,
    Icons.Outlined.Settings
)

@Composable
fun NavBar(modifier: Modifier = Modifier, navController: NavController) {

    var selectedIndex by remember { mutableIntStateOf(0) }

    val navActions = listOf(
        { navController.navigate("home") },
        { navController.navigate("location") },
        { navController.navigate("emergencyContacts") },
        { navController.navigate("settings") }
    )

    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
    val routes = listOf("home", "location", "emergencyContacts", "settings")

    LaunchedEffect(currentRoute) {
        val newIndex = routes.indexOf(currentRoute)

        if(newIndex != -1) {
            selectedIndex = newIndex
        }
    }

    NavigationBar(modifier = modifier) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        if (selectedIndex == index) selectedIcons[index] else unselectedIcons[index],
                        contentDescription = item
                    )
                },
                label = {
                    Text(
                        text = item,
                        textAlign = TextAlign.Center
                    )
                },
                selected = selectedIndex == index,
                onClick = {
                    navActions[index]() //navigate to screen
                }
            )
        }
    }
}

//for composable
@Preview(showBackground = true)
@Composable
fun NavBarPreview() {
    QuickSOSTheme {
        val navController = NavController(LocalContext.current)
        NavBar(navController = navController)
    }
}