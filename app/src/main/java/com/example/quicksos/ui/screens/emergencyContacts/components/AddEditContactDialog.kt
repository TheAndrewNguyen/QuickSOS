package com.example.quicksos.ui.screens.emergencyContacts.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.quicksos.ui.screens.emergencyContacts.viewModel.EmergencyContactsViewModel
import com.example.quicksos.ui.theme.QuickSOSTheme

@Composable
fun CustomEntryField(
    label: String = "",
    value: String,
    updateValue: (value: String) -> Unit,
    keyBoardType: KeyboardType = KeyboardType.Text,
    modifier: Modifier = Modifier,
) {
    OutlinedTextField(
        label = { Text(label) },
        value = value,
        onValueChange = { value ->
            updateValue(value)
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = MaterialTheme.colorScheme.onSurface,
            unfocusedBorderColor = MaterialTheme.colorScheme.onSurface,
            focusedLabelColor = MaterialTheme.colorScheme.onSurface,
            unfocusedLabelColor = MaterialTheme.colorScheme.onSurface,
        ),
        maxLines = 1,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyBoardType
        ),
        modifier = modifier
            .padding(horizontal = 4.dp, vertical = 4.dp)
    )
}

@Composable
fun CustomDecisionButton(text: String, onClick: () -> Unit) {
    TextButton(
        onClick = { onClick() },
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier
        )
    }
}

@Composable
fun AddEditContactDialog(
    viewModel: EmergencyContactsViewModel = hiltViewModel(),
    onDismissRequest: () -> Unit,
) {
    Dialog(
        onDismissRequest = { onDismissRequest() }
    ) {
        Card(
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
                .padding(16.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            ) {
                //title
                Text(
                    text = viewModel.dialogTitle,
                    style = MaterialTheme.typography.titleLarge
                )
                //first name entry field
                CustomEntryField(
                    label = "First Name",
                    value = viewModel.currentFirstName,
                    updateValue = { viewModel.updateFirstName(it) },
                )
                //last name entry field
                CustomEntryField(
                    label = "Last Name",
                    value = viewModel.currentLastName,
                    updateValue = { viewModel.updateLastName(it) },
                )
                //phone number entry field
                CustomEntryField(
                    label = "Phone Number",
                    keyBoardType = KeyboardType.Number,
                    value = viewModel.currentPhoneNumber,
                    updateValue = { viewModel.updatePhoneNumber(it) },
                )

                //if invalid input show invalid message
                if (!viewModel.entryFieldValidInput) {
                    Row(
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(vertical = 4.dp)
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = "*Invalid Input",
                            color = MaterialTheme.colorScheme.error,
                            style = MaterialTheme.typography.labelLarge,
                            modifier = Modifier.padding(end = 30.dp)
                        )
                    }
                }

                //Add and cancel buttons
                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.End),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(vertical = 4.dp)
                        .fillMaxWidth()
                ) {
                    CustomDecisionButton(text = "Cancel", onClick = {
                        onDismissRequest()
                        viewModel.resetEntryFieldValues()
                    })

                    CustomDecisionButton(text = "Add", onClick = {
                        viewModel.onSubmit()
                        if (viewModel.entryFieldValidInput) {
                            onDismissRequest()
                        }
                    })
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddContactDialogPreview() {
    QuickSOSTheme {
        AddEditContactDialog(
            onDismissRequest = {},
        )
    }
}