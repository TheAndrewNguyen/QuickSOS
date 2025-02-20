package com.example.quicksos.ui.screens.settings

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.quicksos.ui.screens.settings.pages.MainPage
import com.example.quicksos.ui.screens.settings.viewModel.SettingsViewModel
import com.example.quicksos.ui.screens.settings.viewModel.UiState

@Composable
fun SettingsScreen(navController: NavController) {
    val viewModel: SettingsViewModel = hiltViewModel()
    when (viewModel.uiState.value) {
        UiState.MainSettings -> {
            MainPage(navController)
        }

        UiState.AppearanceSettings -> {

        }

        UiState.Text911Settings -> {

        }

        UiState.HelpSettings -> {

        }
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview() {
    SettingsScreen(navController = NavController(LocalContext.current))
}

