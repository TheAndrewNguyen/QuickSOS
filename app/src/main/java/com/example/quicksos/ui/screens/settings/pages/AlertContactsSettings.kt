package com.example.quicksos.ui.screens.settings.pages

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.quicksos.ui.screens.settings.components.SubSettingsScaffold

@Composable
fun AlertContactsSettingsPage() {
    SubSettingsScaffold(title = "Alert Contacts Settings")
}

@Preview
@Composable
fun AlertContactsSettingsPreview() {
    AlertContactsSettingsPage()
}