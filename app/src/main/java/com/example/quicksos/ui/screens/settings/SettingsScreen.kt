package com.example.quicksos.ui.screens.settings

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.quicksos.ui.shared.layouts.TitleContentNavScaffold
import com.example.quicksos.ui.shared.layouts.components.CustomTopAppBar
import com.example.quicksos.ui.shared.layouts.components.TitleTextAlign

@Composable
fun SettingsScreen() {

    val title = @Composable {
        TitleTextAlign("Settings", TextAlign.Start)
    }

    val customTopAppBar = @Composable {
        CustomTopAppBar(title = title)
    }

    TitleContentNavScaffold(
        topBar = { customTopAppBar() },
        content = {},
        bottomBar = {},
    )
}

@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview() {
    SettingsScreen()
}

