package com.example.quicksos.data.repository

import com.example.quicksos.data.db.dao.ContactDao
import com.example.quicksos.data.db.entity.Contact
import javax.inject.Inject

class ContactsDbRepository @Inject constructor(private val dao: ContactDao) {
    //insert a new contact
    fun insertContact(contact: Contact) = dao.insert(contact)

    //delete contact
    fun deleteContact(contact: Contact) = dao.delete(contact.uid)

    //update contact
    fun updateContact(uid: Int, contact: Contact) {
        dao.update(
            uid,
            contact.firstName.toString(),
            contact.lastName.toString(),
            contact.phoneNumber.toString()
        )
    }

    // return table sorted
    fun sortByNameAsc(): List<Contact> = dao.sortByNameAsc()

    //return search results
    fun searchContacts(query: String): List<Contact> = dao.search(query)
}