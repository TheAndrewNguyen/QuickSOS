package com.example.quicksos.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.quicksos.data.db.entity.Contact

@Dao
interface ContactDao {

    //get all contacts
    @Query("SELECT * FROM contact")
    fun getAll(): List<Contact>

    //basic manipulation of contacts
    @Insert
    fun insert(vararg contact: Contact)

    @Query("DELETE FROM contact WHERE uid = :uid")
    fun delete(uid: Int)

    //sorting
    @Query("SELECT * FROM contact ORDER BY first_name ASC")
    fun sortByNameAsc(): List<Contact>
}