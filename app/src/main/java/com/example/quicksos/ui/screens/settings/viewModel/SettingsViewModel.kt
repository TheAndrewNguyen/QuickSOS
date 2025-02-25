package com.example.quicksos.ui.screens.settings.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor() : ViewModel() {

    //ui state tracks the current state of the settings screen
    var uiState = mutableStateOf<UiState>(UiState.MainSettings)
        private set

    fun changeUiState(newState: UiState) {
        uiState.value = newState
    }

    //dark theme state tracks if the user has selected dark theme
    var darkTheme = mutableStateOf(false)
        private set

    fun toggleDarkTheme() {
        darkTheme.value = !darkTheme.value
    }

}

sealed class UiState {
    data object MainSettings : UiState()
    data object AppearanceSettings : UiState()
    data object Text911Settings : UiState()
    data object AlertContactsSettings : UiState()
    data object HelpSettings : UiState()
}

