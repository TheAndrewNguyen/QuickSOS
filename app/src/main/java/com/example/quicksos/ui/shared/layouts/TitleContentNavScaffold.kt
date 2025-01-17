package com.example.quicksos.ui.shared.layouts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.quicksos.ui.screens.emergencyContacts.components.SearchBar
import com.example.quicksos.ui.shared.layouts.components.CustomFloatingActionButton
import com.example.quicksos.ui.shared.layouts.components.TitleTextAlign
import com.example.quicksos.ui.theme.QuickSOSTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TitleContentNavScaffold(
    topBar: @Composable ()-> Unit,
    content: @Composable () -> Unit,
    bottomBar: @Composable () -> Unit = {},
    floatingActionButton: @Composable () -> Unit = {},
)
{
    Scaffold(
        topBar = { topBar() },
        bottomBar = { bottomBar() },
        floatingActionButton = { floatingActionButton() },
    ) { innerPadding ->
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier //pass modifier from parent
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            content()
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun TitleNavTemplatePreviewText() {
    val title: @Composable () -> Unit = {
        TitleTextAlign(title = "Quick SOS")
    }
    val topBar: @Composable () -> Unit = {
        TopAppBar(title = title)
    }
    val floatingActionButton: @Composable () -> Unit = {
        CustomFloatingActionButton(
            icon = Icons.Filled.Add,
            contentDescription = "Add"
        )
    }

    QuickSOSTheme(dynamicColor = false) {
        TitleContentNavScaffold(
            topBar = { topBar() },
            content = { Text("Content TESTing") },
            floatingActionButton = { floatingActionButton() }

        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun SearchNavTemplatePreview() {
    val title: @Composable () -> Unit = {
        SearchBar(label = "Search Emergency Contacts")
    }

    val content: @Composable () -> Unit = {
        Text("Content TESTing")
    }

    QuickSOSTheme(dynamicColor = false) {
        TitleContentNavScaffold(
            topBar = { title() },
            content = { content() }
        )
    }
}


