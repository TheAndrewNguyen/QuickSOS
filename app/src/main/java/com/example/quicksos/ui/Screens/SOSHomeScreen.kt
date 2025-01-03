package com.example.quicksos.ui.Screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.quicksos.ui.Backgrounds.Title
import com.example.quicksos.ui.Backgrounds.TitleContentNavScaffold
import com.example.quicksos.ui.Features.ActionButtonColumn
import com.example.quicksos.ui.theme.QuickSOSTheme


@Composable
fun SOSHomeScreen() {
    TitleContentNavScaffold(title = { Title("Quick SOS", titleAlignment = TextAlign.Center) }, content = { ActionButtonColumn()})
}


@Preview(showBackground = true)
@Composable
fun SOSHomeScreenPreview() {
    QuickSOSTheme(dynamicColor = false) {
        SOSHomeScreen()
    }
}
