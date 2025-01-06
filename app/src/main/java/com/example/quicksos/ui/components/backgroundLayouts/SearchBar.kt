package com.example.quicksos.ui.components.backgroundLayouts

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SearchBar(modifier: Modifier = Modifier, label: String = "") {
    TextField(
        value = "",
        onValueChange = {},
        label = { Text(label) },
        singleLine = true,
        shape = RoundedCornerShape(10.dp),
        modifier = modifier
            .height(52.dp)
            .fillMaxWidth()
            .padding(top = 8.dp, start = 16.dp, end = 16.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun SearchBarPreview() {
    SearchBar(label = "Search Emergency Contacts")
}