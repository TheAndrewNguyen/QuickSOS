package com.example.quicksos.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.quicksos.ui.theme.QuickSOSTheme

data class ActionButtonData(val color: Color, val text: @Composable () -> Unit)

@Composable
fun ActionButtonColumn() {

    val actionButtonDataList = listOf(
        ActionButtonData(
            color = MaterialTheme.colorScheme.primary,
            text = { ButtonText("Call 911", "Call emergency services") }
        ),
        ActionButtonData(
            color = MaterialTheme.colorScheme.secondary,
            text = { ButtonText("Text 911", "Text emergency services") }
        ),
        ActionButtonData(
            color = MaterialTheme.colorScheme.tertiary,
            text = { ButtonText("Send SOS", "Alert friends and family") }
        )
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        actionButtonDataList.forEach { it->
            ActionButton(
                Modifier.weight(1f),
                buttonColor = it.color,
                buttonText = it.text
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ActionButtonColumnPreview() {
    QuickSOSTheme(dynamicColor = false){
        ActionButtonColumn()
    }
}