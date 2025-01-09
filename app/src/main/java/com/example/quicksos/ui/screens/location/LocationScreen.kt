package com.example.quicksos.ui.screens.location

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController


@Composable
fun LocationScreen(navController: NavHostController) {
    val viewModel: LocationsViewModel = viewModel()

    Text(text = "Location Screen")
}