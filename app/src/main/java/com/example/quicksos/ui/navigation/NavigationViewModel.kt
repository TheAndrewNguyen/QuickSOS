package com.example.quicksos.ui.navigation


import android.util.Log
import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel

class NavigationViewModel : ViewModel() {

    var selectedNavIndex = mutableIntStateOf(0)
        private set

    fun navBarIndexSet(index: Int) {
        Log.d("NavBar", "NavBarViewModel created")
        Log.d("NavBar", "Index Passed: $index")
        if (selectedNavIndex.intValue == index) return
        selectedNavIndex.intValue = index
        Log.d("NavBar", "Index Set on ViewModel side: ${selectedNavIndex.intValue}")
    }
}