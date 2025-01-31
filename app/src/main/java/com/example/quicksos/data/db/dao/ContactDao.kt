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

    //return list of contact sorted in ascending order by first name
    @Query("SELECT * FROM contact ORDER BY first_name, last_name COLLATE NOCASE ASC")
    fun sortByNameAsc(): List<Contact>

    //returns list of contacts that match query
    @Query("SELECT * FROM contact WHERE first_name COLLATE NOCASE LIKE '%' || :query || '%' OR last_name COLLATE NOCASE LIKE '%' || :query || '%' OR phone_number COLLATE NOCASE LIKE '%' || :query || '%'")
    fun search(query: String): List<Contact>
}