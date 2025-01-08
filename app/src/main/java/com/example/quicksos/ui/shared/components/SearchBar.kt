package com.example.quicksos.ui.shared.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SearchBar(modifier: Modifier = Modifier, label: String = "") {
    OutlinedTextField(
        value = "",
        onValueChange = {},
        label = { Text(label) },
        singleLine = true,
        leadingIcon = { Icon(imageVector = Icons.Filled.Search, contentDescription = "Search") },
        shape = RoundedCornerShape(10.dp),
        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth()
    )
}

@Preview(showBackground = true)
@Composable
fun SearchBarPreview() {
    SearchBar(label = "Search Emergency Contacts")
}