package com.example.quicksos.ui.screens.settings.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SettingsViewModel : ViewModel() {
    var uiState = mutableStateOf<UiState>(UiState.MainSettings)
        private set
}

sealed class UiState {
    data object MainSettings : UiState()
    data object AppearanceSettings : UiState()
    data object Text911Settings : UiState()
    data object HelpSettings : UiState()
}