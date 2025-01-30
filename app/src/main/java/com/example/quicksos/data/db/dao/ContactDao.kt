package com.example.quicksos.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.quicksos.data.db.entity.Contact

@Dao
interface ContactDao {
    //Add Contact
    @Insert
    fun insert(vararg contact: Contact)

    //update contact
    @Query("UPDATE contact SET first_name = :firstName, last_name = :lastName, phone_number = :phoneNumber WHERE uid = :uid")
    fun update(uid: Int, firstName: String, lastName: String, phoneNumber: String)

    //delete the contact
    @Query("DELETE FROM contact WHERE uid = :uid")
    fun delete(uid: Int)

    //sorting contacts ascending
    @Query("SELECT * FROM contact ORDER BY first_name COLLATE NOCASE ASC")
    fun sortByNameAsc(): List<Contact>
}