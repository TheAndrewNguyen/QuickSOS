package com.example.quicksos.ui.screens.settings.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.quicksos.ui.screens.settings.components.SliderPreferenceCard
import com.example.quicksos.ui.screens.settings.components.SubSettingsScaffold
import com.example.quicksos.ui.theme.QuickSOSTheme

@Composable
fun AppearanceSettingsPage() {
    val content: @Composable () -> Unit = {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
        ) {
            SliderPreferenceCard(title = "Dark mode", description = "Toggle dark mode")
        }
    }

    SubSettingsScaffold(title = "Appearance Settings", content = content)
}

@Preview(showBackground = true)
@Composable
fun AppearanceSettingsPreview() {
    QuickSOSTheme {
        AppearanceSettingsPage()
    }
}