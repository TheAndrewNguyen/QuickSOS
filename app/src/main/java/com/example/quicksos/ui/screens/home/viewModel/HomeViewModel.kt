package com.example.quicksos.ui.screens.home.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.quicksos.ui.screens.home.data.ActionButtonDataModel
import com.example.quicksos.ui.screens.home.data.actionButtonData


class HomeViewModel : ViewModel() {
    var actionButtonData = mutableListOf<ActionButtonDataModel>()

    fun getActionData(context: Context) {
        actionButtonData = actionButtonData(context)
    }
}