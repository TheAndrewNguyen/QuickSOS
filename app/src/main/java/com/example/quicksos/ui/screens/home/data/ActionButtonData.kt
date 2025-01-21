package com.example.quicksos.ui.screens.home.data

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.quicksos.ui.screens.home.components.ButtonText
import com.example.quicksos.ui.theme.SOSBlUE
import com.example.quicksos.ui.theme.SOSRED
import com.example.quicksos.ui.theme.SOSYELLOW
import com.example.quicksos.utils.callNumber
import com.example.quicksos.utils.textMultipleNumbers
import com.example.quicksos.utils.textNumber

data class ActionButtonDataModel(
    val color: Color,
    val text: @Composable () -> Unit,
    val action: () -> Unit = {}
)

fun actionButtonData(context: Context): MutableList<ActionButtonDataModel> {
    return mutableListOf<ActionButtonDataModel>(
        ActionButtonDataModel(
            color = SOSRED,
            text = { ButtonText("Call 911", "Call emergency services") },
            action = { callNumber(context = context, number = "911") }
        ),
        ActionButtonDataModel(
            color = SOSBlUE,
            text = { ButtonText("Text 911", "Text emergency services") },
            action = { textNumber(context = context, number = "911", message = "I need help") }
        ),
        ActionButtonDataModel(
            color = SOSYELLOW,
            text = { ButtonText("Alert Contacts", "Notify emergency contacts") },
            action = {
                textMultipleNumbers(
                    context = context,
                    numbers = listOf("1234567890", "0987654321"),
                    message = "I need help"
                )
            })
    )
}
