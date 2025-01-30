package com.example.quicksos.ui.screens.emergencyContacts.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.quicksos.data.db.entity.Contact
import com.example.quicksos.ui.screens.emergencyContacts.viewModel.EmergencyContactsViewModel
import com.example.quicksos.ui.screens.emergencyContacts.viewModel.UiState


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DeleteContactDialog(contactToBeDeleted: Contact?) {
    val viewModel: EmergencyContactsViewModel = hiltViewModel()
    AlertDialog(
        title = {
            Text(text = "Confirm Delete")
        },
        text = {
            Text(text = "Are your sure you want to delete ${contactToBeDeleted?.firstName} ${contactToBeDeleted?.lastName} from your emergency contacts?")
        },
        onDismissRequest = {
            viewModel.updateUiState(UiState.BaseContent)
        },
        confirmButton = {
            TextButton(
                onClick = {
                    viewModel.deleteContact(contactToBeDeleted!!)
                    viewModel.updateUiState(UiState.BaseContent)
                }
            ) {
                Text(
                    text = "Yes",
                    color = androidx.compose.material3.MaterialTheme.colorScheme.onSurface
                )
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    viewModel.updateUiState(UiState.BaseContent)
                }
            ) {
                Text(
                    text = "No"
                )
            }
        }
    )
}

//preview does not work
@Preview(showBackground = true)
@Composable
fun DeleteContactDialogPreview() {
    val viewModel: EmergencyContactsViewModel = hiltViewModel()

    val contact = Contact(
        firstName = "John",
        lastName = "Doe",
        phoneNumber = "1234567890"
    )
    DeleteContactDialog(contactToBeDeleted = contact)
}