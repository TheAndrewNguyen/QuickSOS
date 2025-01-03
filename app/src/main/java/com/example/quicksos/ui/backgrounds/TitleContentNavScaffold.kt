package com.example.quicksos.ui.backgrounds

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.quicksos.ui.components.NavBar
import com.example.quicksos.ui.components.TopAppBarTitle
import com.example.quicksos.ui.theme.QuickSOSTheme



@Composable
fun FloatingActionButton(icon: ImageVector, onClick: () -> Unit = {}, contentDescription: String) {
    FloatingActionButton(onClick = onClick) {
        Icon(icon, contentDescription)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TitleContentNavScaffold(topBar: @Composable ()-> Unit, content: @Composable () -> Unit, floatingActionButton: @Composable () -> Unit = {}) {
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
fun TitleNavTemplatePreview() {
    val title: @Composable () -> Unit = {
        TopAppBarTitle(title = "Quick SOS")
    }
    val topBar: @Composable () -> Unit = {
        TopAppBar(title = title)
    }
    val floatingActionButton: @Composable () -> Unit = {
        FloatingActionButton(
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

