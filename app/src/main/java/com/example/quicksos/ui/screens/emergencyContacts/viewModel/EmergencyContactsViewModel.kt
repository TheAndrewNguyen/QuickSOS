package com.example.quicksos.ui.screens.emergencyContacts.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.quicksos.data.db.entity.Contact
import com.example.quicksos.data.repository.ContactsDbRepository
import com.example.quicksos.utils.hasTextLength
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EmergencyContactsViewModel @Inject constructor(
    private val repository: ContactsDbRepository
) : ViewModel()  {

    //list to be presented
    var contactsList by mutableStateOf(emptyList<Contact>())

    //show dialog variable
    var showAddContactDialog by mutableStateOf(false)
        private set

    //is valid input in show dialogs correct
    var validInput by mutableStateOf(true)

    //Dialog box fields
    var currentFirstName by mutableStateOf("")
        private set
    var currentLastName by mutableStateOf("")
        private set
    var currentPhoneNumber by mutableStateOf("")
        private set

    //to be changed to update state
    fun updateShowDialog(bool: Boolean) {
        showAddContactDialog = bool
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

    //reset values
    fun resetEntryFieldValues() {
        updateFirstName("")
        updateLastName("")
        updatePhoneNumber("")
        validInput = true
    }

    //on submit button clicked
    fun onSubmit() {
        //check if all input boxes are greater than one
        if(!hasTextLength(currentFirstName)
            || !hasTextLength(currentLastName)
            || !hasTextLength(currentPhoneNumber)) {
            validInput = false
            return
        }

        //format data
        val data = Contact(
            firstName = currentFirstName.toString(),
            lastName = currentLastName.toString(),
            phoneNumber = currentPhoneNumber.toString()
        )

        //send data to the backend
        repository.insertContact(data)

        //reset the values on the front end
        resetEntryFieldValues()
    }

    fun updateData() {
        contactsList = repository.sortByNameAsc()
    }
}