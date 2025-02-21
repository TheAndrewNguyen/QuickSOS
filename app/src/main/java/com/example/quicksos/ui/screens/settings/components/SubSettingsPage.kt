package com.example.quicksos.ui.screens.settings.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.quicksos.ui.screens.settings.viewModel.SettingsViewModel
import com.example.quicksos.ui.screens.settings.viewModel.UiState
import com.example.quicksos.ui.shared.layouts.TitleContentNavScaffold
import com.example.quicksos.ui.shared.layouts.components.CustomTopAppBar
import com.example.quicksos.ui.shared.layouts.components.TitleTextAlign
import com.example.quicksos.ui.theme.QuickSOSTheme

@Composable
fun SubSettingsScaffold(
    title: String,
    content: @Composable () -> Unit = {}
){
    val viewModel: SettingsViewModel = hiltViewModel()

    //topBar attributes
    val titleText: @Composable () -> Unit = { TitleTextAlign(title, TextAlign.Start, MaterialTheme.typography.headlineSmall) }
    val backIcon: @Composable () -> Unit = {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = "Back",
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .clickable {
                    viewModel.changeUiState(UiState.MainSettings)
                }
        )
    }

    val topBar: @Composable () -> Unit = {
        CustomTopAppBar(
            modifier = Modifier,
            navigationIcon = backIcon,
            title = titleText
        )
    }

    TitleContentNavScaffold(
        topBar = topBar,
        content = { content },
    )
}

@Preview(showBackground = true)
@Composable
fun SubSettingsTopBarPreview() {
    QuickSOSTheme {
        SubSettingsScaffold("Preview")
    }
}



