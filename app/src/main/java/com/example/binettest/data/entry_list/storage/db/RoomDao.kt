package com.example.binettest.data.entry_list.storage.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.binettest.data.entry_list.storage.db.models.EntryDetailsDB

// Data Access Object
@Dao
interface RoomDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertEntry(entry: EntryDetailsDB)
}
