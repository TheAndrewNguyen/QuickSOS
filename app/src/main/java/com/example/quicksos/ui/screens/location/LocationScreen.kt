package com.example.quicksos.ui.screens.location

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun LocationScreen() {
    val viewModel: LocationsViewModel = viewModel()

    Text(text = "Location Screen")
}