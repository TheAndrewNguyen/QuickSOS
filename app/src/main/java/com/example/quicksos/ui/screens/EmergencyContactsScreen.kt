package com.example.quicksos.ui.screens

import android.R.attr.contentDescription
import android.R.attr.onClick
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.quicksos.ui.backgrounds.FloatingActionButton
import com.example.quicksos.ui.backgrounds.Title
import com.example.quicksos.ui.backgrounds.TitleContentNavScaffold
import com.example.quicksos.ui.backgrounds.TopAppBar
import com.example.quicksos.ui.components.ActionButtonColumn
import com.example.quicksos.ui.theme.QuickSOSTheme

@Composable
fun EmergencyContactScreen() {
    val title: @Composable () -> Unit = {
        Title(title = "Emergency Contacts", titleAlignment = TextAlign.Center)
    }    
    
    val topBar: @Composable () -> Unit = {
        TopAppBar(
            title = title
        )
    }
    
    val floatingActionButton: @Composable () -> Unit = {
        FloatingActionButton(
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