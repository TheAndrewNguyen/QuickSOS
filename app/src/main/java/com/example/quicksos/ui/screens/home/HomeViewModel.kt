package com.example.quicksos.ui.screens.home

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.quicksos.ui.screens.home.data.ActionButtonDataModel
import com.example.quicksos.ui.screens.home.data.loadActionButtonData


class HomeViewModel : ViewModel() {
    var actionButtonData = mutableListOf<ActionButtonDataModel>()

    fun getActionData(context: Context) {
        actionButtonData = loadActionButtonData(context)
    }
}