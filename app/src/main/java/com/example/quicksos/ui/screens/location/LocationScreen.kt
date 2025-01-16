package com.example.quicksos.ui.screens.location

import MapCompose
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.quicksos.navigation.NavigationViewModel
import com.example.quicksos.ui.shared.layouts.CustomTopAppBar
import com.example.quicksos.ui.shared.layouts.NavBar
import com.example.quicksos.ui.shared.layouts.TitleContentNavScaffold
import com.example.quicksos.ui.shared.layouts.TitleTextAlign
import com.example.quicksos.ui.theme.QuickSOSTheme

@Composable
fun Location() {
    Column(
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text("(Coordinates: 47.583914, -122.150077)")
        Text("(Address: 1234 Main St, Anytown USA)")

    }
}

@Composable
fun LocationScreenContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        MapCompose()
        Location()
    }
}



@Composable
fun LocationScreen(navController: NavController, navigationViewModel: NavigationViewModel = viewModel()) {

    val title: @Composable () -> Unit = {
        TitleTextAlign(title = "Current Location")
    }

    val topBar: @Composable () -> Unit = {
        CustomTopAppBar(modifier = Modifier, title = title)
    }

    val content : @Composable () -> Unit = {
        LocationScreenContent()
    }

    val bottomBar: @Composable () -> Unit = {
        NavBar(navController = navController, navBarViewModel = navigationViewModel)
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