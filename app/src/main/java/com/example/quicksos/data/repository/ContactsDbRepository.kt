package com.example.quicksos.data.repository

import com.example.quicksos.data.db.database.ContactsDatabase
import javax.inject.Inject

class ContactsDbRepository @Inject constructor(
    private val contactsDatabase: ContactsDatabase
    ){
    fun getAllContacts() = contactsDatabase.contactDao().getAll()
}