package com.example.quicksos.data.db.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.quicksos.data.db.dao.ContactDao
import com.example.quicksos.data.db.entity.Contact

@Database(entities = [Contact::class], version = 1)
abstract class ContactsDatabase : RoomDatabase() {
    abstract fun contactDao(): ContactDao
}