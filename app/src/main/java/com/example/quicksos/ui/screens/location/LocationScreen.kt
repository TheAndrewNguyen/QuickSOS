package com.example.quicksos.ui.screens.location

import MapCompose
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.quicksos.ui.theme.QuickSOSTheme

@Composable
fun LocationScreen() {
    MapCompose()
}


@Preview(showBackground = true)
@Composable
fun LocationScreenPreivew() {
    QuickSOSTheme {
        LocationScreen()
    }
}