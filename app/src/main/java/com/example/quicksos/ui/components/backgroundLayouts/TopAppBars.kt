package com.example.quicksos.ui.components.backgroundLayouts

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign

@Composable
fun TopAppBarTitle(title: String = "", titleAlignment: TextAlign = TextAlign.Center) {
    if(title != "") {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineMedium,
            textAlign = titleAlignment,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar(title: @Composable ()-> Unit) {
    TopAppBar(
        colors = topAppBarColors(
            containerColor = MaterialTheme.colorScheme.background,
            titleContentColor = MaterialTheme.colorScheme.onBackground,
        ),
        title = { title() }
    )
}