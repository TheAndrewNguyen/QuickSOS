package com.example.quicksos.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.quicksos.ui.theme.QuickSOSTheme

@Composable
fun ActionButtonColumn() {
    val viewModel: HomeViewModel = viewModel()
    val actionButtonDataList = viewModel.actionButtonData

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