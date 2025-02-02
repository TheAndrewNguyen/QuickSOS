package com.example.quicksos.ui.screens.emergencyContacts.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.quicksos.ui.screens.emergencyContacts.viewModel.EmergencyContactsViewModel

//TODO: Add back button on focused mode, back button unfocuses the composable
@Composable
fun SearchBar(modifier: Modifier = Modifier, label: String = "") {
    val viewModel: EmergencyContactsViewModel = hiltViewModel()

    //focus manager
    val searchBarFocusRequestor = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current

    //variable to track if search bar is focused or not
    var searchBarIsFocused = remember {mutableStateOf(false)}

    OutlinedTextField(
        value = viewModel.searchbarContent,
        onValueChange = {
            viewModel.updateSearchContent(it)
        },
        label = { Text(label) },
        singleLine = true,
        leadingIcon = {
            Icon(
                imageVector = if(searchBarIsFocused.value) Icons.AutoMirrored.Filled.ArrowBack else Icons.Filled.Search,
                contentDescription = if(searchBarIsFocused.value) "Back Arrow" else "Search",
                modifier = Modifier.clickable { //when click
                    if(searchBarIsFocused.value) {
                        viewModel.updateSearchContent("") //clear search content on back button
                        focusManager.clearFocus()
                    } else {
                        null
                    }
                }
            )
        },
        shape = RoundedCornerShape(10.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = MaterialTheme.colorScheme.onSurface,
            unfocusedBorderColor = MaterialTheme.colorScheme.onSurface,
            focusedLabelColor = MaterialTheme.colorScheme.onSurface,
            unfocusedLabelColor = MaterialTheme.colorScheme.onSurface
        ),
        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 24.dp)
            .fillMaxWidth()
            .focusRequester(searchBarFocusRequestor)
            //state management for search bar
            .onFocusChanged { focusState ->
                searchBarIsFocused.value = focusState.isFocused
            }
    )
}

@Preview(showBackground = true)
@Composable
fun SearchBarPreview() {
    SearchBar(label = "Search Emergency Contacts")
}