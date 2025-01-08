package com.example.quicksos.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.quicksos.ui.theme.QuickSOSTheme
import com.example.quicksos.utils.callNumber
import com.example.quicksos.utils.textMultipleNumbers
import com.example.quicksos.utils.textNumber


//TODO: Get view models and contacts page working so we can get this part working
data class ActionButtonData(val color: Color, val text: @Composable () -> Unit, val action : () -> Unit = {})
@Composable
fun ActionButtonColumn() {

    val context = LocalContext.current

    val actionButtonDataList = listOf(
        ActionButtonData(
            color = MaterialTheme.colorScheme.primary,
            text = { ButtonText("Call 911", "Call emergency services") },
            action = { callNumber(context = context , number = "911") }
        ),
        ActionButtonData(
            color = MaterialTheme.colorScheme.secondary,
            text = { ButtonText("Text 911", "Text emergency services") },
            action = { textNumber(context = context , number = "911", message = "I need help") }
        ),
        ActionButtonData(
            color = MaterialTheme.colorScheme.tertiary,
            text = { ButtonText("Send SOS", "Alert friends and family") },
            action = { textMultipleNumbers(context = context, numbers = listOf("1234567890", "0987654321"), message = "I need help") }
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
                buttonText = it.text,
                buttonAction = { it.action() }
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