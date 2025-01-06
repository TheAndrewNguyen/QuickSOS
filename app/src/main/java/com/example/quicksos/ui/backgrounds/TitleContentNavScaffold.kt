package com.example.quicksos.ui.backgrounds

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.example.quicksos.ui.components.backgroundLayouts.CustomFloatingActionButton
import com.example.quicksos.ui.components.backgroundLayouts.NavBar
import com.example.quicksos.ui.components.backgroundLayouts.SearchBar
import com.example.quicksos.ui.components.backgroundLayouts.TopAppBarTitle
import com.example.quicksos.ui.theme.QuickSOSTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TitleContentNavScaffold(
    topBar: @Composable ()-> Unit,
    content: @Composable () -> Unit,
    floatingActionButton: @Composable () -> Unit = {})
{
    Scaffold(
        topBar = { topBar() },
        bottomBar = { NavBar(Modifier.fillMaxWidth()) },
        floatingActionButton = { floatingActionButton() },
    ) { innerPadding ->
        Column(
            modifier = Modifier //pass modifier from parent
                .padding(innerPadding)
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
        TopAppBarTitle(title = "Quick SOS")
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


