package com.example.quicksos.ui.screens.settings

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun SettingsScreen() {
    val viewModel: SettingsViewModel = viewModel()
    Text(text = "Settings Screen")
}