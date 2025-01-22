package com.example.quicksos.ui.screens.emergencyContacts.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.quicksos.ui.theme.QuickSOSTheme

@Composable
fun EntryField(modifier: Modifier = Modifier, label: String = "") {
    OutlinedTextField(
        value = "",
        onValueChange = {},
        label = { Text(label) },
        singleLine = true,
        modifier = modifier
            .padding(horizontal = 4.dp)
    )
}

@Composable
fun DecisionButton(text: String, onClick: () -> Unit) {
    Button(onClick = { onClick }) {
        Text(text = text,
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier
        )
    }
}

@Composable
fun AddContactContent() {
    Column(
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Add Contact",
            style = MaterialTheme.typography.titleLarge
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        ) {
            EntryField(label = "First Name", modifier = Modifier.weight(0.5f))
            EntryField(label = "Last Name", modifier = Modifier.weight(0.5f))
        }
        EntryField(label = "Phone Number")

        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.End),
            modifier = Modifier
                .padding(vertical = 16.dp)
                .fillMaxWidth()
        ) {
            DecisionButton(text = "Cancel", onClick = {})
            DecisionButton(text = "Add", onClick = {})
        }
    }
}

@Composable
fun AddContactDialog(
    onDismissRequest: () -> Unit,
    content: @Composable () -> Unit
) {
    Dialog(
        onDismissRequest = {onDismissRequest}
    ) {
        Card(
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(325.dp)
                .padding(16.dp)
        ) {
            content()
        }
    }
}

@Preview
@Composable
fun EntryFieldPreview() {
    EntryField(label = "Name")
}
@Preview(showBackground = true)
@Composable
fun AddContactContentPreview() {
    AddContactContent()
}

@Preview(showBackground = true)
@Composable
fun AddContactDialogPreview() {
    QuickSOSTheme {
        AddContactDialog(onDismissRequest = {}, content = { AddContactContent() })
    }
}