package com.example.quicksos.ui.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.quicksos.ui.navigation.NavigationViewModel
import com.example.quicksos.ui.screens.home.components.ActionButtonColumn
import com.example.quicksos.ui.screens.home.viewModel.HomeViewModel
import com.example.quicksos.ui.shared.layouts.TitleContentNavScaffold
import com.example.quicksos.ui.shared.layouts.components.CustomTopAppBar
import com.example.quicksos.ui.shared.layouts.components.NavBar
import com.example.quicksos.ui.shared.layouts.components.TitleTextAlign
import com.example.quicksos.ui.theme.QuickSOSTheme

@Composable
fun SOSHomeScreen(navController: NavController, navigationViewModel: NavigationViewModel = viewModel()) {
    val viewModel: HomeViewModel = viewModel()
    val navViewModel: NavigationViewModel = hiltViewModel()

    //action button data
    val context = LocalContext.current
    viewModel.getActionData(context) //initialize action button data

    LaunchedEffect(Unit) {
        viewModel.getActionData(context)
    }

    val title: @Composable () -> Unit = {
        TitleTextAlign(title = "Quick SOS")
    }

    val topBar: @Composable () -> Unit = {
        CustomTopAppBar(modifier = Modifier, title = title)
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
