package com.example.quicksos.ui.shared.layouts.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview


//Just text topBarTitle
@Composable
fun TitleTextAlign(
    title: String = "",
    titleAlignment: TextAlign = TextAlign.Center,
    style: TextStyle = MaterialTheme.typography.headlineLarge,
    modifier: Modifier = Modifier
) {
    Text(
        text = title,
        style = style,
        textAlign = titleAlignment,
        modifier = modifier.fillMaxWidth()
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar(
    modifier: Modifier = Modifier,
    navigationIcon: @Composable () -> Unit = {},
    title: @Composable () -> Unit) {
    TopAppBar(
        colors = topAppBarColors(
            containerColor = MaterialTheme.colorScheme.background,
            titleContentColor = MaterialTheme.colorScheme.onBackground,
        ),
        navigationIcon = navigationIcon,
        title = { title() },
        modifier = modifier
            .fillMaxWidth()
    )
}

//preview for basic top app var
@Preview(showBackground = true)
@Composable
fun TopAppBarTitlePreview() {
    TitleTextAlign(title = "Quick SOS")
}