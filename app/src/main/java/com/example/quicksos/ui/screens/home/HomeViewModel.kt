package com.example.quicksos.ui.screens.home

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.example.quicksos.ui.theme.SOSBlUE
import com.example.quicksos.ui.theme.SOSRED
import com.example.quicksos.ui.theme.SOSYELLOW
import com.example.quicksos.utils.callNumber
import com.example.quicksos.utils.textMultipleNumbers
import com.example.quicksos.utils.textNumber

data class ActionButtonData(
    val color: Color,
    val text: @Composable () -> Unit,
    val action: () -> Unit = {}
)

class HomeViewModel : ViewModel() {
    var actionButtonData = mutableListOf<ActionButtonData>()

    fun loadActionData(context: Context) {
        val actionButtonDataList = listOf(
            ActionButtonData(
                color = SOSRED,
                text = { ButtonText("Call 911", "Call emergency services") },
                action = { callNumber(context = context, number = "911") }
            ),
            ActionButtonData(
                color = SOSBlUE,
                text = { ButtonText("Text 911", "Text emergency services") },
                action = { textNumber(context = context, number = "911", message = "I need help") }
            ),
            ActionButtonData(
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

        actionButtonData = actionButtonDataList.toMutableList()
    }
}