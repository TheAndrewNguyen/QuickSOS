package com.example.quicksos.ui.screens.home.components

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
import androidx.compose.ui.unit.dp

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
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Composable
fun ActionButton(modifier: Modifier = Modifier, buttonColor: Color, buttonText: @Composable () -> Unit, buttonAction: () -> Unit = {}) {
    Button(
        onClick = { buttonAction() },
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




