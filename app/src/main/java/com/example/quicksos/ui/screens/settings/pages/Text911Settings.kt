package com.example.quicksos.ui.screens.settings.pages

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.quicksos.ui.screens.settings.components.SubSettingsScaffold
import com.example.quicksos.ui.theme.QuickSOSTheme


@Composable
fun Text911SettingsPage() {
    SubSettingsScaffold(title = "Text 911 Settings")
}

@Preview(showBackground = true)
@Composable
fun Text911SettingsPagePreview() {
    QuickSOSTheme {
        Text911SettingsPage()
    }
}

