package com.example.quicksos.ui.screens.home

import android.content.Context
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quicksos.utils.callNumber
import com.example.quicksos.utils.textMultipleNumbers
import com.example.quicksos.utils.textNumber

data class ActionButtonData(val color: Color, val text: @Composable () -> Unit, val action : () -> Unit = {})

class HomeViewModel : ViewModel() {

    //ActionButtonData
    private val _actionButtonData = MutableLiveData<List<ActionButtonData>>()
    val actionButtonData: LiveData<List<ActionButtonData>> get() = _actionButtonData

    @Composable
    fun LoadActionData(context: Context) {
        _actionButtonData.value = listOf(
            ActionButtonData(
                color = MaterialTheme.colorScheme.primary,
                text = { ButtonText("Call 911", "Call emergency services") },
                action = { callNumber(context = context, number = "911") }
            ),
            ActionButtonData(
                color = MaterialTheme.colorScheme.secondary,
                text = { ButtonText("Text 911", "Text emergency services") },
                action = { textNumber(context = context, number = "911", message = "I need help") }
            ),
            ActionButtonData(
                color = MaterialTheme.colorScheme.tertiary,
                text = { ButtonText("Send SOS", "Alert friends and family") },
                action = {
                    textMultipleNumbers(
                        context = context,
                        numbers = listOf("1234567890", "0987654321"),
                        message = "I need help"
                    )
                })
        )
    }
}