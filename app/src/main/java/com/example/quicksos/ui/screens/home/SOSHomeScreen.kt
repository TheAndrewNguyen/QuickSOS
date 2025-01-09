package com.example.quicksos.ui.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.quicksos.ui.shared.backgrounds.TitleContentNavScaffold
import com.example.quicksos.ui.shared.components.CustomTopAppBar
import com.example.quicksos.ui.shared.components.TopAppBarTitle
import com.example.quicksos.ui.shared.components.bottomNavBar.NavBar
import com.example.quicksos.ui.theme.QuickSOSTheme

@Composable
fun SOSHomeScreen(navController: NavController) {
    val viewModel: HomeViewModel = viewModel()

    //action button data
    val context = LocalContext.current
    viewModel.loadActionData(context)

    LaunchedEffect(Unit) {
        viewModel.loadActionData(context)
    }

    val title: @Composable () -> Unit = {
        TopAppBarTitle(title = "Quick SOS")
    }
    val topBar: @Composable () -> Unit = {
        CustomTopAppBar(title = title)
    }
    val actionButtonColumn : @Composable () -> Unit = {
        ActionButtonColumn()
    }

    val bottomBar: @Composable () -> Unit = {
        NavBar(navController = navController)
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
