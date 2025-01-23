package com.example.quicksos.ui.screens.emergencyContacts.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quicksos.ui.theme.QuickSOSTheme


@Composable
fun NameAndPhoneNumber(name: String, phoneNumber: String) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .background(MaterialTheme.colorScheme.surface)
    ) {
        Text(text = name, style = MaterialTheme.typography.titleLarge)
        Text(text = phoneNumber, style = MaterialTheme.typography.bodyMedium)
    }
}

@Composable
fun EmergencyTapButtonGroup() {
    Button( //call button
        onClick = {},
        modifier = Modifier
            .padding(16.dp)
            .background(MaterialTheme.colorScheme.surface)
    ) {
        Icon(Icons.Default.Call, contentDescription = "Call")
    }
}

@Composable
fun EmergencyContactCard(name: String, phoneNumber: String) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp)
            .background(MaterialTheme.colorScheme.surface)
        ) {
        NameAndPhoneNumber(name = name, phoneNumber = phoneNumber)
        EmergencyTapButtonGroup()
    }
}

@Composable
fun EmergencyContactsColumn() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(10) {
            EmergencyContactCard(name = "John Doe", phoneNumber = "123-456-7890")
        }
    }
}



@Preview(showBackground = true)
@Composable
fun EmergencyContactCardPreview() {
    QuickSOSTheme {
        EmergencyContactCard(name = "John Doe", phoneNumber = "123-456-7890")
    }
}