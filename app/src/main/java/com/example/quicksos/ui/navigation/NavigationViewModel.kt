package com.example.quicksos.ui.navigation


import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NavigationViewModel @Inject constructor() : ViewModel() {

    var selectedNavIndex = mutableIntStateOf(0)
        private set

    fun navBarIndexSet(index: Int) {
        if (selectedNavIndex.intValue == index) return
        selectedNavIndex.intValue= index
    }
}