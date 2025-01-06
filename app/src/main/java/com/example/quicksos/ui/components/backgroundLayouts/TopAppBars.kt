package com.example.quicksos.ui.components.backgroundLayouts

import android.R.attr.label
import android.R.attr.singleLine
import android.R.attr.value
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quicksos.ui.theme.QuickSOSTheme


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

//SearchTopBarTitle
@Composable
fun TopAppBarTitle(title: @Composable () -> Unit) {
    title()
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

//preview for search bar top bar
@Preview(showBackground = true)
@Composable
fun CustomTopAppBarPreview() {
    QuickSOSTheme(dynamicColor = false) {
        val searchBar: @Composable () -> Unit = {
            SearchBar(
                Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .fillMaxSize(),
                label = "Search emergency contacts"
            )
        }
        CustomTopAppBar(
            modifier = Modifier
                .fillMaxWidth(),
            title = searchBar
        )
    }
}