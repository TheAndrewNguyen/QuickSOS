package com.example.quicksos.ui.Features

import android.R.attr.enabled
import android.R.attr.text
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quicksos.ui.components.TitleContentNavScaffold
import com.example.quicksos.ui.theme.QuickSOSTheme


@Composable
fun ActionButton(ButtonText: String, ButtonColor: Color,) {
    Button(
        onClick = { /*TODO*/ },
        enabled = true,
        colors = ButtonColors(
            containerColor = ButtonColor,
            contentColor = MaterialTheme.colorScheme.onBackground,
            disabledContainerColor = Color.Gray, //TODO: Look into this later
            disabledContentColor = Color.LightGray
        ),
        modifier = Modifier
            .size(372.dp, 187.dp)
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
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        ActionButtonsValues.forEach {
            ActionButton(ButtonText = it.ButtonText, ButtonColor = it.ButtonColor)
        }
    }
}

@Composable
fun SOSHomeScreen() {
    TitleContentNavScaffold(title = "Quick SOS", content = { ActionButtonColumn()})
}


@Preview(showBackground = true)
@Composable
fun ActionButtonPreview() {
    QuickSOSTheme(dynamicColor = false) {
        SOSHomeScreen()
    }
}
