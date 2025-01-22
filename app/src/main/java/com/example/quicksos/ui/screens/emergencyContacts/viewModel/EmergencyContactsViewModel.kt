package com.example.quicksos.ui.screens.emergencyContacts.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.quicksos.ui.screens.emergencyContacts.data.emergencyContactsDataModel


class EmergencyContactsViewModel : ViewModel() {

    //show dialog variable
    var showDialog by mutableStateOf(false)
        private set

    //current dialog box
    var currentFirstName by mutableStateOf("")
        private set
    var currentLastName by mutableStateOf("")
        private set
    var currentPhoneNumber by mutableStateOf("")
        private set

    //Setters
    fun updateShowDialog(bool: Boolean) {
        showDialog = bool
    }

    fun updateFirstName(firstName: String) {
        currentFirstName = firstName
    }

    fun updateLastName(lastName: String) {
        currentLastName = lastName
    }

    fun updatePhoneNumber(phoneNumber: String) {
        currentPhoneNumber = phoneNumber
    }

    //on submit button clicked
    fun onSubmit() {
        val data = emergencyContactsDataModel(firstName = currentFirstName, lastName = currentLastName, phoneNumber = currentPhoneNumber)
        updateFirstName("")
        updateLastName("")
        updatePhoneNumber("")

        /*TODO send data back to the backend*/
    }
}