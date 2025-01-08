package com.example.quicksos.ui.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.quicksos.ui.shared.backgrounds.TitleContentNavScaffold
import com.example.quicksos.ui.shared.components.CustomTopAppBar
import com.example.quicksos.ui.shared.components.TopAppBarTitle
import com.example.quicksos.ui.theme.QuickSOSTheme

@Composable
fun SOSHomeScreen() {
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

    TitleContentNavScaffold(
        topBar = { topBar() },
        content = { actionButtonColumn() },
    )
}


@Preview(showBackground = true)
@Composable
fun SOSHomeScreenPreview() {
    QuickSOSTheme(dynamicColor = false) {
        SOSHomeScreen()
    }
}
