package com.example.quicksos.ui.screens.settings.pages

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.quicksos.ui.screens.settings.components.SubSettingsScaffold

@Composable
fun HelpSettingsPage() {
    SubSettingsScaffold(title = "Help and Support")
}

@Preview(showBackground = true)
@Composable
fun HelpSettingsPreview() {
    HelpSettingsPage()
}
