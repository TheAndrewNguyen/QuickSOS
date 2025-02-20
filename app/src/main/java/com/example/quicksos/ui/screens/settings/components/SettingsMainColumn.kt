package com.example.quicksos.ui.screens.settings.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SettingsMainColumn() {
    Column(
        modifier = Modifier
        .fillMaxSize()
    ) {
        //Appearance card
        PreferenceCard(
            modifier = Modifier,
            title = "Appearance",
            description = "Customize theme and appearance settings"
        )
        // Text 911 card
        PreferenceCard(
            modifier = Modifier,
            title = "Text 911",
            description = "Customize text 911 settings"
        )
        // Alert Contacts
        PreferenceCard(
            modifier = Modifier,
            title = "Alert Contacts",
            description = "Customize Alert Cntacts Settings"
        )
        //Help and Support
        PreferenceCard(
            modifier = Modifier,
            title = "Help and Support",
            description = "Get help and support"
        )
    }
}

@Preview
@Composable
fun SettingsColumnPreview() {
    SettingsMainColumn()
}