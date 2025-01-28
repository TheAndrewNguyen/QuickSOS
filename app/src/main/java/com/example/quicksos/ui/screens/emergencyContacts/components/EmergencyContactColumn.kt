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

@Composable
fun EmergencyContactsColumn() {
    val viewModel: EmergencyContactsViewModel = hiltViewModel()

    LaunchedEffect(Unit) {
        viewModel.updateData()
    }

    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = if(viewModel.contactsList.isEmpty()) Arrangement.Center else Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
    ) {
        //contact cards
        if(viewModel.contactsList.isEmpty()) {
            item {
                Text(
                    text = "No Emergency Contacts",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
        viewModel.contactsList.forEach {
            item {
                EmergencyContactCard(
                    name = it.firstName + " " + it.lastName,
                    phoneNumber = it.phoneNumber.toString()
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EmergencyContactsColumnPreview() {
    EmergencyContactsColumn()
}