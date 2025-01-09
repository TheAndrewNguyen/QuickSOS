package com.example.quicksos.ui.screens.home

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.quicksos.navigation.NavigationViewModel
import com.example.quicksos.ui.shared.layouts.CustomTopAppBar
import com.example.quicksos.ui.shared.layouts.NavBar
import com.example.quicksos.ui.shared.layouts.TitleContentNavScaffold
import com.example.quicksos.ui.shared.layouts.TitleTextAlign
import com.example.quicksos.ui.theme.QuickSOSTheme

@Composable
fun SOSHomeScreen(navController: NavController, navigationViewModel: NavigationViewModel = viewModel()) {
    val viewModel: HomeViewModel = viewModel()

    //action button data
    val context = LocalContext.current
    viewModel.loadActionData(context)

    LaunchedEffect(Unit) {
        viewModel.loadActionData(context)
    }

    val title: @Composable () -> Unit = {
        TitleTextAlign(title = "Quick SOS")
    }

    val topBar: @Composable () -> Unit = {
        CustomTopAppBar(modifier = Modifier.padding(top = 10.dp), title = title)
    }

    val actionButtonColumn : @Composable () -> Unit = {
        ActionButtonColumn()
    }

    val bottomBar: @Composable () -> Unit = {
        NavBar(navController = navController, navBarViewModel = navigationViewModel)
    }

    TitleContentNavScaffold(
        topBar = { topBar() },
        content = { actionButtonColumn() },
        bottomBar = { bottomBar() }
    )
}


@Preview(showBackground = true)
@Composable
fun SOSHomeScreenPreview() {
    QuickSOSTheme(dynamicColor = false) {
        val navController = rememberNavController()
        SOSHomeScreen(navController)
    }
}
