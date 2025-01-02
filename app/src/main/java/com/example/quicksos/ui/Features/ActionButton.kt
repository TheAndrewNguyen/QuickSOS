package com.example.quicksos.ui.Features

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
import androidx.compose.ui.unit.dp

@Composable
fun ActionButton(modifier: Modifier = Modifier, ButtonText: String, ButtonColor: Color,) {
    Button(
        onClick = { /*TODO*/ },
        enabled = true,
        colors = ButtonColors(
            containerColor = ButtonColor,
            contentColor = Color.White,
            disabledContainerColor = Color.Gray, //TODO: Look into this later
            disabledContentColor = Color.LightGray
        ),
        modifier = modifier
            .fillMaxWidth()
            .padding(18.dp)
    ) {
        Text(
            text = ButtonText,
            style = MaterialTheme.typography.displaySmall)
    }
}


data class ActionButtonData(val ButtonText: String, val ButtonColor: Color)

@Composable
fun ActionButtonColumn(){
    val ActionButtonsValues = listOf(
        ActionButtonData("Call 911", MaterialTheme.colorScheme.primary),
        ActionButtonData("Text 911", MaterialTheme.colorScheme.secondary),
        ActionButtonData("SOS", MaterialTheme.colorScheme.tertiary)
    )

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        ActionButtonsValues.forEach {
            ActionButton(Modifier.weight(1f), ButtonText = it.ButtonText, ButtonColor = it.ButtonColor)
        }
    }
}
