package com.example.quicksos.ui.screens.emergencyContacts.viewModel

import androidx.lifecycle.ViewModel
import com.example.quicksos.ui.screens.emergencyContacts.data.emergencyContactsDataModel

class EmergencyContactsViewModel : ViewModel() {
    val emergencyContacts = mutableListOf<emergencyContactsDataModel>()

    fun getEmergencyContacts() {
        //TODO
    }
}