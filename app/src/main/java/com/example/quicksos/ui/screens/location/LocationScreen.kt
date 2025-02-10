package com.example.quicksos.ui.screens.location

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.quicksos.ui.navigation.NavBar
import com.example.quicksos.ui.navigation.NavigationViewModel
import com.example.quicksos.ui.screens.location.components.LocationScreenContent
import com.example.quicksos.ui.shared.layouts.TitleContentNavScaffold
import com.example.quicksos.ui.shared.layouts.components.CustomTopAppBar
import com.example.quicksos.ui.shared.layouts.components.TitleTextAlign
import com.example.quicksos.ui.theme.QuickSOSTheme


@Composable
fun LocationScreen(
    navController: NavController
) {
    val navViewModel: NavigationViewModel = hiltViewModel()

    val title: @Composable () -> Unit = {
        TitleTextAlign(title = "Current Location")
    }

    val topBar: @Composable () -> Unit = {
        CustomTopAppBar(modifier = Modifier, title = title)
    }

    val content: @Composable () -> Unit = {
        LocationScreenContent(navController, navViewModel)
    }

    val bottomBar: @Composable () -> Unit = {
        NavBar(navController = navController)
    }

    TitleContentNavScaffold(
        topBar = { topBar() },
        content = { content() },
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
