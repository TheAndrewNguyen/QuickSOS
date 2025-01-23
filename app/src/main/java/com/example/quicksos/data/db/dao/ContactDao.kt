package com.example.quicksos.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.quicksos.data.db.entity.Contact

@Dao
interface ContactDao {
    @Query("SELECT * FROM contact")
    fun getAll(): List<Contact>

    @Insert
    fun insert(contact: Contact)
}