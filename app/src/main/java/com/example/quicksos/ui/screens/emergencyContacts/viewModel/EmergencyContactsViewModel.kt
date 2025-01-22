package com.example.quicksos.ui.screens.emergencyContacts.viewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.quicksos.ui.screens.emergencyContacts.data.emergencyContactsDataModel


class EmergencyContactsViewModel : ViewModel() {

    //current dialog box
    var currentFirstName by mutableStateOf("")
        private set
    var currentLastName by mutableStateOf("")
        private set
    var currentPhoneNumber by mutableStateOf("")
        private set

    fun updateFirstName(firstName: String) {
        currentFirstName = firstName
    }

    fun updateLastName(lastName: String) {
        currentLastName = lastName
    }

    fun updatePhoneNumber(phoneNumber: String) {
        currentPhoneNumber = phoneNumber
    }

    fun onSubmit() {
        val data = emergencyContactsDataModel(firstName = currentFirstName, lastName = currentLastName, phoneNumber = currentPhoneNumber)
        Log.d("EmergencyContactsViewModel", "onSubmit: $data")
        updateFirstName("")
        updateLastName("")
        updatePhoneNumber("")
    }
}