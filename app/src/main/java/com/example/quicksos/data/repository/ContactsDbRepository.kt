package com.example.quicksos.data.repository

import com.example.quicksos.data.db.dao.ContactDao
import com.example.quicksos.data.db.entity.Contact
import javax.inject.Inject

class ContactsDbRepository @Inject constructor(private val dao : ContactDao) {
    fun getAllContacts() : List<Contact> = dao.getAll()
}