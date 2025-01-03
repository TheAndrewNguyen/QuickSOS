package com.example.quicksos.ui.Backgrounds

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.quicksos.ui.Features.NavBar
import com.example.quicksos.ui.theme.QuickSOSTheme

@Composable
fun Title(title: String, titleAlignment: TextAlign = TextAlign.Center) {
    Text(
        text = title,
        style = MaterialTheme.typography.headlineMedium,
        textAlign = titleAlignment,
        modifier = Modifier.fillMaxWidth()
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TitleContentNavScaffold(title: @Composable ()-> Unit, content: @Composable () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background,
                    titleContentColor = MaterialTheme.colorScheme.onBackground,
                ),
                title = { title() }
            )
        },
        bottomBar = { NavBar(Modifier.fillMaxWidth()) }
    ) { innerPadding ->
        Column(
            modifier = Modifier //pass modifier from parent
                .padding(innerPadding)
        ) {
            content()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun TitleNavTemplatePreview() {
    QuickSOSTheme {
        TitleContentNavScaffold(title = { Title("Quick SOS") }, content = { Text("Content") })
    }
}

