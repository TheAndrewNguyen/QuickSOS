package com.example.quicksos.ui.screens.emergencyContacts.viewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quicksos.data.db.entity.Contact
import com.example.quicksos.data.repository.ContactsDbRepository
import com.example.quicksos.utils.validateTextLengthGreaterThanOne
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EmergencyContactsViewModel @Inject constructor(
    private val repository: ContactsDbRepository
) : ViewModel()  {

    //show dialog variable
    var showDialog by mutableStateOf(false)
        private set

    var validInput by mutableStateOf(true)

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

    fun resetValues() {
        updateFirstName("")
        updateLastName("")
        updatePhoneNumber("")
        validInput = true
    }

    //on submit button clicked
    fun onSubmit() : Boolean {
        //check if all input boxes are greater than one
        if(!validateTextLengthGreaterThanOne(currentFirstName)
            && !validateTextLengthGreaterThanOne(currentLastName)
            && !validateTextLengthGreaterThanOne(currentPhoneNumber)) {
            validInput = false
            return false
        }

        //format data
        val data = Contact(
            firstName = currentFirstName.toString(),
            lastName = currentLastName.toString(),
            phoneNumber = currentPhoneNumber.toString()
        )

        Log.d("onSubmit", "onSubmit: $data")

        //send data to the backend
        repository.insertContact(data)


        //reset the values on the front end
        resetValues()

        return true
    }
}