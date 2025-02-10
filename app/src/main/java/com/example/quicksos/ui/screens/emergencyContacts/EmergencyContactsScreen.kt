package com.example.quicksos.ui.screens.emergencyContacts

import IndividualContactDialog
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.quicksos.ui.navigation.NavigationViewModel
import com.example.quicksos.ui.screens.emergencyContacts.components.AddEditContactDialog
import com.example.quicksos.ui.screens.emergencyContacts.components.DeleteContactDialog
import com.example.quicksos.ui.screens.emergencyContacts.components.EmergencyContactsColumn
import com.example.quicksos.ui.screens.emergencyContacts.components.SearchBar
import com.example.quicksos.ui.screens.emergencyContacts.viewModel.EmergencyContactsViewModel
import com.example.quicksos.ui.screens.emergencyContacts.viewModel.UiState
import com.example.quicksos.ui.shared.layouts.TitleContentNavScaffold
import com.example.quicksos.ui.shared.layouts.components.CustomFloatingActionButton
import com.example.quicksos.ui.shared.layouts.components.NavBar
import com.example.quicksos.ui.theme.QuickSOSTheme

@Composable
fun EmergencyContactScreen(
    navController: NavHostController,
) {

    val viewModel: EmergencyContactsViewModel = hiltViewModel()
    val navViewModel: NavigationViewModel = hiltViewModel()

    val topBar: @Composable () -> Unit = {
        SearchBar(label = "Search Emergency Contacts")
    }

    val floatingActionButton: @Composable () -> Unit = {
        CustomFloatingActionButton(
            icon = Icons.Filled.Add,
            onClick = { viewModel.updateUiState(UiState.AddContactDialog) },
            contentDescription = "Add Emergency Contact"
        )
    }

    val content: @Composable () -> Unit = {
        when (viewModel.uiState.value) {
            UiState.BaseContent -> {
                EmergencyContactsColumn()
            }

            UiState.AddContactDialog ->
                AddEditContactDialog(
                    viewModel = viewModel,
                    onDismissRequest = { viewModel.updateUiState(UiState.BaseContent) }
                )

            UiState.ShowContactDialog -> {
                IndividualContactDialog(
                    contact = viewModel.selectedContact,
                    onDismissRequest = {
                        viewModel.updateUiState(UiState.BaseContent)
                        viewModel.selectedContact = null
                        viewModel.resetEntryFieldValues()
                    }
                )
            }

            UiState.EditContactDialog -> {
                viewModel.updateFirstName(viewModel.selectedContact?.firstName.toString())
                viewModel.updateLastName(viewModel.selectedContact?.lastName.toString())
                viewModel.updatePhoneNumber(viewModel.selectedContact?.phoneNumber.toString())
                AddEditContactDialog(
                    viewModel = viewModel,
                    onDismissRequest = {
                        viewModel.updateUiState(UiState.BaseContent)
                        viewModel.selectedContact = null
                        viewModel.resetEntryFieldValues()
                    }
                )
            }

            UiState.DeleteContactDialog -> {
                DeleteContactDialog(contactToBeDeleted = viewModel.selectedContact)
            }
        }
    }

    val bottomBar: @Composable () -> Unit = {
        NavBar(navController = navController)
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