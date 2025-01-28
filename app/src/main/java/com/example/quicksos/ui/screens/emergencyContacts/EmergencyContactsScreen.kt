package com.example.quicksos.ui.screens.emergencyContacts

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.quicksos.ui.navigation.NavigationViewModel
import com.example.quicksos.ui.screens.emergencyContacts.components.AddContactDialog
import com.example.quicksos.ui.screens.emergencyContacts.components.EmergencyContactsColumn
import com.example.quicksos.ui.screens.emergencyContacts.components.SearchBar
import com.example.quicksos.ui.screens.emergencyContacts.viewModel.EmergencyContactsViewModel
import com.example.quicksos.ui.screens.emergencyContacts.viewModel.UiState
import com.example.quicksos.ui.shared.layouts.TitleContentNavScaffold
import com.example.quicksos.ui.shared.layouts.components.CustomFloatingActionButton
import com.example.quicksos.ui.shared.layouts.components.NavBar
import com.example.quicksos.ui.theme.QuickSOSTheme

@Composable
fun EmergencyContactScreen(navController: NavHostController, navBarViewModel: NavigationViewModel = viewModel()) {

    val viewModel: EmergencyContactsViewModel = hiltViewModel()

    val topBar: @Composable () -> Unit = {
        SearchBar(label = "Search Emergency Contacts")
    }
    
    val floatingActionButton: @Composable () -> Unit = {
        CustomFloatingActionButton(
            icon = Icons.Filled.Add,
            onClick = { viewModel.updateUiState(UiState.AddDialog) },
            contentDescription = "Add Emergency Contact"
        )
    }

    val content: @Composable () -> Unit = {
        when(viewModel.uiState.value) {
            UiState.NoDialog -> { EmergencyContactsColumn() }
            UiState.AddDialog ->
                AddContactDialog(
                viewModel = viewModel,
                onDismissRequest = { viewModel.updateUiState(UiState.NoDialog) }
            )
            UiState.EditDialog -> { TODO() }
        }
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