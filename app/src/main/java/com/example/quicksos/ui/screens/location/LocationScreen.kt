package com.example.quicksos.ui.screens.location

import MapCompose
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.quicksos.navigation.NavigationViewModel
import com.example.quicksos.ui.shared.layouts.CustomTopAppBar
import com.example.quicksos.ui.shared.layouts.NavBar
import com.example.quicksos.ui.shared.layouts.TitleContentNavScaffold
import com.example.quicksos.ui.shared.layouts.TitleTextAlign
import com.example.quicksos.ui.theme.QuickSOSTheme

@Composable
fun LocationScreen(navController: NavController, navigationViewModel: NavigationViewModel = viewModel()) {

    val title: @Composable () -> Unit = {
        TitleTextAlign(title = "Current Location")
    }

    val topBar: @Composable () -> Unit = {
        CustomTopAppBar(modifier = Modifier, title = title)
    }

    val map : @Composable () -> Unit = {
        MapCompose()
    }

    val bottomBar: @Composable () -> Unit = {
        NavBar(navController = navController, navBarViewModel = navigationViewModel)
    }

    TitleContentNavScaffold(
        topBar = { topBar() },
        content = { map() },
        bottomBar = { bottomBar() }
    )
}


@Preview(showBackground = true)
@Composable
fun LocationScreenPreview() {
    QuickSOSTheme {
        LocationScreen(navController = NavController(LocalContext.current))
    }
}