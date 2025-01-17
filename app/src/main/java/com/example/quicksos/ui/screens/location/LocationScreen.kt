package com.example.quicksos.ui.screens.location

import MapCompose
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.quicksos.navigation.NavigationViewModel
import com.example.quicksos.ui.shared.layouts.CustomTopAppBar
import com.example.quicksos.ui.shared.layouts.NavBar
import com.example.quicksos.ui.shared.layouts.TitleContentNavScaffold
import com.example.quicksos.ui.shared.layouts.TitleTextAlign
import com.example.quicksos.ui.theme.QuickSOSTheme

@Composable
fun InformationText(modifier: Modifier = Modifier, text: String) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp

    val fontSize = when {
        screenWidth > 600 -> 20.sp  // Large screens (e.g., tablets)
        screenWidth > 400 -> 18.sp  // Medium screens (e.g., phones)
        else -> 16.sp               // Small screens
    }

    Text(
        text = text,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp), // Adjust padding for better spacing
        fontSize = fontSize,
        fontStyle = MaterialTheme.typography.displayMedium.fontStyle,
        maxLines = 2,
    )
}

@Composable
fun LocationInfo(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        InformationText(text = "Coordinates: (47.583914, -122.150077)")
        InformationText(text = "Address: 1234 Main St, Anytown USA")
    }
}

@Composable
fun HelpButton(
    modifier: Modifier = Modifier,
    navController: NavController,
    navViewModel: NavigationViewModel
) {
    Button(
        onClick = {
            navController.navigate("Home")
            navViewModel.navBarIndexSet(0)
        },
        colors = ButtonDefaults.buttonColors(),
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp) // Consistent vertical padding
    ) {
        Text(
            text = "Get Help",
            style = MaterialTheme.typography.displayMedium
        )
    }
}

@Composable
fun LocationScreenContent(navController: NavController, navViewModel: NavigationViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        MapCompose(modifier = Modifier.weight(0.7f)) // Adjust map size dynamically
        LocationInfo(modifier = Modifier.weight(0.1f)) // Adjust weight for better layout distribution
        HelpButton(
            modifier = Modifier.weight(0.2f), // Adjust weight for button size consistency
            navController = navController,
            navViewModel = navViewModel
        )
    }
}

@Composable
fun LocationScreen(
    navController: NavController,
    navigationViewModel: NavigationViewModel = viewModel()
) {
    val title: @Composable () -> Unit = {
        TitleTextAlign(title = "Current Location")
    }

    val topBar: @Composable () -> Unit = {
        CustomTopAppBar(modifier = Modifier, title = title)
    }

    val content: @Composable () -> Unit = {
        LocationScreenContent(navController, navigationViewModel)
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
