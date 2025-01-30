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
        private set

    //ui state of screen
    var uiState = mutableStateOf<UiState>(UiState.BaseContent)
        private set

    fun updateUiState(state: UiState) {
        uiState.value = state
    }

    //DIALOG FIELDS
    //DIALOG title
    var dialogTitle by mutableStateOf("Add Contact")
        private set

    fun updateDialogTitle(title: String) {
        dialogTitle = title
    }
    //first name Entry Field
    var currentFirstName by mutableStateOf("")
        private set

    fun updateFirstName(firstName: String) {
        currentFirstName = firstName
    }

    //last name Entry Field
    var currentLastName by mutableStateOf("")
        private set

    fun updateLastName(lastName: String) {
        currentLastName = lastName
    }

    //phone number Entry Field
    var currentPhoneNumber by mutableStateOf("")
        private set

    fun updatePhoneNumber(phoneNumber: String) {
        currentPhoneNumber = phoneNumber
    }

    var selectedContact by mutableStateOf<Contact?>(null)

    //is valid input in show dialogs correct
    var entryFieldValidInput by mutableStateOf(true)

    //reset values
    fun resetEntryFieldValues() {
        updateFirstName("")
        updateLastName("")
        updatePhoneNumber("")
        updateDialogTitle("Add Contact")
        selectedContact = null
        entryFieldValidInput = true
    }

    //on submit button clicked
    fun onSubmit() {
        //check if all input boxes are greater than one
        if(!hasTextLength(currentFirstName)
            || !hasTextLength(currentLastName)
            || !hasTextLength(currentPhoneNumber)) {
            entryFieldValidInput = false
            return
        }

        //format data
        val data = Contact(
            firstName = currentFirstName.toString(),
            lastName = currentLastName.toString(),
            phoneNumber = currentPhoneNumber.toString()
        )

        if(uiState.value == UiState.AddContactDialog) {
            repository.insertContact(data)
            resetEntryFieldValues()
            return
        }

        //if updating a contact
        if(uiState.value == UiState.EditContactDialog) {
            val oldContactUid = selectedContact?.uid
            repository.updateContact(oldContactUid!!,data)
            resetEntryFieldValues()
            return
        }
    }

    //delete teh contact
    fun deleteContact(contact: Contact) {
        repository.deleteContact(contact)
        resetEntryFieldValues()
        updateData()
    }

    //update data form the backend
    fun updateData() {
        contactsList = repository.sortByNameAsc()
    }
}

sealed class UiState() {
    object BaseContent : UiState()
    object SearchContent : UiState()
    object AddContactDialog : UiState()
    object ShowContactDialog : UiState()
    object EditContactDialog: UiState()
    object DeleteContactDialog: UiState()
}