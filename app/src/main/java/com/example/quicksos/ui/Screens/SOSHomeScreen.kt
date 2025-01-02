package com.example.quicksos.ui.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
