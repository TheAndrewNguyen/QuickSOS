package com.example.quicksos.ui.screens.settings

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.quicksos.ui.navigation.NavBar
import com.example.quicksos.ui.screens.settings.components.SettingsMainColumn
import com.example.quicksos.ui.shared.layouts.TitleContentNavScaffold
import com.example.quicksos.ui.shared.layouts.components.CustomTopAppBar
import com.example.quicksos.ui.shared.layouts.components.TitleTextAlign

@Composable
fun SettingsScreen(navController: NavController) {

    val title = @Composable {
        TitleTextAlign("Settings", TextAlign.Start)
    }

    val customTopAppBar = @Composable {
        CustomTopAppBar(modifier = Modifier.padding(4.dp),title = title)
    }



    TitleContentNavScaffold(
        topBar = { customTopAppBar() },
        content = { SettingsMainColumn() },
        bottomBar = {NavBar(navController = navController)},
    )
}

@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview() {
    SettingsScreen(navController = NavController(LocalContext.current))
}

