package com.example.quicksos.ui.Features

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quicksos.ui.theme.QuickSOSTheme

@Composable
fun ButtonText(title: String, description: String = "") {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.displaySmall
        )
        if(description != "") {
            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}


@Composable
fun ActionButton(modifier: Modifier = Modifier, buttonColor: Color, buttonText: @Composable () -> Unit) {
    Button(
        onClick = { /*TODO*/ },
        enabled = true,
        colors = ButtonColors(
            containerColor = buttonColor,
            contentColor = Color.White,
            disabledContainerColor = Color.Gray, //TODO: Look into this later
            disabledContentColor = Color.LightGray
        ),
        contentPadding = PaddingValues(1.dp),
        modifier = modifier
            .fillMaxWidth()
            .padding(18.dp)
    ) {
        buttonText()
    }
}


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
            text = { ButtonText("Send SOS", "Alert friends and family with your location") }
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
