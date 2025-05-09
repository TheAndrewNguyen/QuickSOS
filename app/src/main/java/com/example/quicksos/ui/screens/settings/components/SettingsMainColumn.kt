package com.example.quicksos.ui.screens.settings.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.quicksos.ui.screens.settings.viewModel.SettingsViewModel
import com.example.quicksos.ui.screens.settings.viewModel.UiState

@Composable
fun SettingsMainColumn() {
    val viewModel: SettingsViewModel = hiltViewModel()

    Column(
        modifier = Modifier
        .fillMaxSize()
    ) {
        //Appearance card
        PreferenceCardBase(
            modifier = Modifier
                .clickable {
                    viewModel.changeUiState(UiState.AppearanceSettings)
                },
            title = "Appearance",
            description = "Customize theme and appearance settings"
        )
        // Text 911 card
        PreferenceCardBase(
            modifier = Modifier
                .clickable {
                    viewModel.changeUiState(UiState.Text911Settings)
                },
            title = "Text 911",
            description = "Customize text 911 settings"
        )
        // Alert Contacts
        PreferenceCardBase(
            modifier = Modifier
                .clickable {
                    viewModel.changeUiState(UiState.AlertContactsSettings)
                },
            title = "Alert Contacts",
            description = "Customize Alert Cntacts Settings"
        )
        //Help and Support
        PreferenceCardBase(
            modifier = Modifier
                .clickable {
                    viewModel.changeUiState(UiState.HelpSettings)
                },
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