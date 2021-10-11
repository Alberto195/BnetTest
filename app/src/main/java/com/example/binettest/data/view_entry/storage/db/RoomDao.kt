package com.example.binettest.data.view_entry.storage.db

import androidx.room.*
import com.example.binettest.data.view_entry.storage.db.models.EntryDetailsDB

@Dao
interface RoomDao {
    @Query("SELECT * FROM view_entry WHERE id = 0")
    fun getEntry(): EntryDetailsDB

    @Delete
    fun deleteEntry(entry: EntryDetailsDB)
}
