package com.example.quicksos.ui.screens.emergencyContacts

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.quicksos.navigation.NavigationViewModel
import com.example.quicksos.ui.shared.backgrounds.TitleContentNavScaffold
import com.example.quicksos.ui.shared.backgrounds.CustomFloatingActionButton
import com.example.quicksos.ui.shared.backgrounds.SearchBar
import com.example.quicksos.ui.shared.backgrounds.NavBar
import com.example.quicksos.ui.theme.QuickSOSTheme

@Composable
fun EmergencyContactScreen(navController: NavHostController, navBarViewModel: NavigationViewModel = viewModel()) {
    
    val topBar: @Composable () -> Unit = {
        SearchBar(modifier = Modifier, label = "Search Emergency Contacts")
    }
    
    val floatingActionButton: @Composable () -> Unit = {
        CustomFloatingActionButton(
            icon = Icons.Filled.Add,
            onClick = { /*TODO*/},
            contentDescription = "Add Emergency Contact"
        )
    }

    val content: @Composable () -> Unit = {
        /*TODO*/
    }

    val bottomBar: @Composable () -> Unit = {
        NavBar(navController = navController, navBarViewModel = navBarViewModel)
    }
    
    TitleContentNavScaffold(
        topBar = { topBar() },
        floatingActionButton = { floatingActionButton() },
        content = { content() },
        bottomBar = { bottomBar() }
    )
}


@Preview(showBackground = true)
@Composable
fun EmergencyContactScreenPreview() {
    QuickSOSTheme(dynamicColor = false) {
        val navController = rememberNavController()
        EmergencyContactScreen(navController)
    }
}