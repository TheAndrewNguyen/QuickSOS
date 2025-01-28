package com.example.quicksos.data.repository

import com.example.quicksos.data.db.dao.ContactDao
import com.example.quicksos.data.db.entity.Contact
import javax.inject.Inject

class ContactsDbRepository @Inject constructor(private val dao : ContactDao) {
    fun getAllContacts() : List<Contact> = dao.getAll()

    //getting the exact contact form the search
    fun getExactContact(firstName: String, lastName: String, phoneNumber: String) : List<Contact>
    = dao.getExact(firstName, lastName, phoneNumber)

    //insert a new contact
    fun insertContact(contact: Contact) = dao.insert(contact)

    //delete contact
    fun deleteContact(contact: Contact) =  dao.delete(contact.uid)

    //sort inputs
    fun sortByNameAsc() : List<Contact> = dao.sortByNameAsc()
}