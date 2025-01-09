package com.example.quicksos.ui.shared.backgrounds

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


//Just text topBarTitle
@Composable
fun TopAppBarTitle(title: String = "", titleAlignment: TextAlign = TextAlign.Center) {
    Text(
        text = title,
        style = MaterialTheme.typography.headlineMedium,
        textAlign = titleAlignment,
        modifier = Modifier.fillMaxWidth()
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar(modifier: Modifier = Modifier, title: @Composable () -> Unit) {
    TopAppBar(
        colors = topAppBarColors(
            containerColor = MaterialTheme.colorScheme.background,
            titleContentColor = MaterialTheme.colorScheme.onBackground,
        ),
        title = { title() },
        modifier = modifier
            .height(56.dp)
            .fillMaxWidth()
    )
}

//preview for basic top app var
@Preview(showBackground = true)
@Composable
fun TopAppBarTitlePreview() {
    TopAppBarTitle(title = "Quick SOS")
}