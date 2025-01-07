package com.example.quicksos.ui.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.quicksos.ui.backgrounds.TitleContentNavScaffold
import com.example.quicksos.ui.components.backgroundLayouts.CustomFloatingActionButton
import com.example.quicksos.ui.components.backgroundLayouts.SearchBar
import com.example.quicksos.ui.theme.QuickSOSTheme

@Composable
fun EmergencyContactScreen() {
    
    val topBar: @Composable () -> Unit = {
        SearchBar(modifier = Modifier, label = "Search Emergency Contacts")
    }
    
    val floatingActionButton: @Composable () -> Unit = {
        CustomFloatingActionButton(
            icon = Icons.Filled.Add,
            onClick = { /*TODO*/},
            contentDescription = "Add Emergency Contact"
        )
    }

    val content: @Composable () -> Unit = {
        /*TODO*/
    }
    
    TitleContentNavScaffold(
        topBar = { topBar() },
        floatingActionButton = { floatingActionButton() },
        content = { content() }
    )
}


@Preview(showBackground = true)
@Composable
fun EmergencyContactScreenPreview() {
    QuickSOSTheme(dynamicColor = false) {
        EmergencyContactScreen()
    }
}