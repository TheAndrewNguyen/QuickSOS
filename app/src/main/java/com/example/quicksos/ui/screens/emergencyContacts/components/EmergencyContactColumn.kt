package com.example.quicksos.ui.screens.emergencyContacts.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.quicksos.ui.screens.emergencyContacts.viewModel.EmergencyContactsViewModel
import com.example.quicksos.ui.screens.emergencyContacts.viewModel.UiState

@Composable
fun EmergencyContactsColumn() {
    val viewModel: EmergencyContactsViewModel = hiltViewModel()

    LaunchedEffect(Unit) {
        viewModel.updateData()
    }

    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = if (viewModel.contactsList.isEmpty()) Arrangement.Center else Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
    ) {
        //if there are no contacts display message
        if (viewModel.contactsList.isEmpty()) {
            item {
                Text(
                    text = "No Emergency Contacts",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
        //if there are contacts populate the contact cards
        items(viewModel.contactsList.size) { index ->
            EmergencyContactCard(contact = viewModel.contactsList[index]) { contact ->
                //when clicked update selectedContact
                viewModel.selectedContact = contact

                //update ui state
                viewModel.updateUiState(UiState.EditDialog)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EmergencyContactsColumnPreview() {
    EmergencyContactsColumn()
}