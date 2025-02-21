package com.example.quicksos.ui.screens.settings.pages

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.quicksos.ui.screens.settings.components.SubSettingsScaffold

@Composable
fun AppearanceSettingsPage() {
    SubSettingsScaffold(title = "Appearance Settings")
}

@Preview(showBackground = true)
@Composable
fun AppearanceSettingsPreview() {
    AppearanceSettingsPage()
}