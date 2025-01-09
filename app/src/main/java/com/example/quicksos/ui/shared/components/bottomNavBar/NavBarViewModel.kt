package com.example.quicksos.ui.shared.components.bottomNavBar

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NavBarViewModel : ViewModel() {
    private val _selectedNavIndex = MutableLiveData<Int>(0)
    val selectedNavIndex: LiveData<Int> = _selectedNavIndex

    fun navIndexSet(index: Int) {
        if (_selectedNavIndex.value == index) return
        _selectedNavIndex.value = index
    }
}