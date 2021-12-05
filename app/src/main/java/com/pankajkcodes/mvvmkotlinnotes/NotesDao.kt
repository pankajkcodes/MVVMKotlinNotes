package com.pankajkcodes.mvvmkotlinnotes

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface NotesDao {


    @Insert
    suspend fun insertNotes(note: NotesModel) {

    }

    @Delete

    suspend fun deleteNotes(note: NotesModel) {

    }

    @Query("SELECT * FROM notes")
    fun getNotes(): LiveData<List<NotesModel>>
}