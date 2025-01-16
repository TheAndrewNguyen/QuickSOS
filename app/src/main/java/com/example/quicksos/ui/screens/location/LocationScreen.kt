package com.example.quicksos.ui.screens.location

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.quicksos.ui.theme.QuickSOSTheme

@Composable
fun LocationScreen() {
    Text("Location Screen")
}


@Preview(showBackground = true)
@Composable
fun LocationScreenPreivew() {
    QuickSOSTheme {
        LocationScreen()
    }
}