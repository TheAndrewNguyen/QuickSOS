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
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.quicksos.ui.screens.emergencyContacts.viewModel.EmergencyContactsViewModel
import com.example.quicksos.ui.theme.QuickSOSTheme

/*TODO: Refactor this to accomodate data entry*/
@Composable
fun EntryField(
    modifier: Modifier = Modifier,
    keyBoardType: KeyboardType = KeyboardType.Text,
    value: String,
    updateValue: (value: String) -> Unit,
    label: String = "",
) {

    OutlinedTextField(
        value = value,
        onValueChange = { value -> updateValue(value) },
        label = { Text(label) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyBoardType
        ),
        modifier = modifier
            .padding(horizontal = 4.dp)
    )
}

@Composable
fun DecisionButton(text: String, onClick: () -> Unit) {
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
fun AddContactDialog(
    onDismissRequest: () -> Unit,
) {
    val viewModel: EmergencyContactsViewModel = viewModel()

    Dialog(
        onDismissRequest = { onDismissRequest() }
    ) {
        Card(
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(325.dp)
                .padding(16.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
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
                    EntryField(
                        label = "First Name",
                        value = viewModel.currentFirstName,
                        updateValue = { viewModel.updateFirstName(it) },
                        modifier = Modifier.weight(0.5f)
                    )
                    EntryField(
                        label = "Last Name",
                        value = viewModel.currentLastName,
                        updateValue = { viewModel.updateLastName(it) },
                        modifier = Modifier.weight(0.5f)
                    )
                }
                EntryField(
                    label = "Phone Number",
                    keyBoardType = KeyboardType.Number,
                    value = viewModel.currentPhoneNumber,
                    updateValue = { viewModel.updatePhoneNumber(it) },
                )

                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.End),
                    modifier = Modifier
                        .padding(vertical = 16.dp)
                        .fillMaxWidth()
                ) {
                    DecisionButton(text = "Cancel", onClick = { onDismissRequest() })
                    DecisionButton(text = "Add", onClick = { viewModel.onSubmit() })
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun AddContactDialogPreview() {
    QuickSOSTheme {
        AddContactDialog(
            onDismissRequest = {},
        )
    }
}