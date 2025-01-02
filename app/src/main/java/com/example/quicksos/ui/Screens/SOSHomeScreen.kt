package com.example.quicksos.ui.Screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.quicksos.ui.Backgrounds.TitleContentNavScaffold
import com.example.quicksos.ui.Features.ActionButtonColumn
import com.example.quicksos.ui.theme.QuickSOSTheme


@Composable
fun SOSHomeScreen() {
    TitleContentNavScaffold(title = "Quick SOS", titleAlignment = TextAlign.Center, content = { ActionButtonColumn()})
}


@Preview(showBackground = true)
@Composable
fun ActionButtonPreview() {
    QuickSOSTheme(dynamicColor = false) {
        SOSHomeScreen()
    }
}
