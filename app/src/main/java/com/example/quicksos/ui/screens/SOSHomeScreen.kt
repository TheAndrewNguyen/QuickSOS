package com.example.quicksos.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.quicksos.ui.backgrounds.Title
import com.example.quicksos.ui.backgrounds.TitleContentNavScaffold
import com.example.quicksos.ui.components.ActionButtonColumn
import com.example.quicksos.ui.theme.QuickSOSTheme


@Composable
fun SOSHomeScreen() {
    val title = "Quick SOS"
    val textAlignment = TextAlign.Center
    val actionButtonColumn : @Composable () -> Unit = {
        ActionButtonColumn()
    }

    TitleContentNavScaffold(
        title = { Title(title, textAlignment) },
        content = { actionButtonColumn },
    )
}


@Preview(showBackground = true)
@Composable
fun SOSHomeScreenPreview() {
    QuickSOSTheme(dynamicColor = false) {
        SOSHomeScreen()
    }
}
