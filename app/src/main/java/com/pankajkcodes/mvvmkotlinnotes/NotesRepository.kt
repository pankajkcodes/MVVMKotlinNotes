package com.pankajkcodes.mvvmkotlinnotes

import androidx.lifecycle.LiveData

class NotesRepository(private val notesDao: NotesDao) {

    suspend fun insertNotes(notes:NotesModel) {

        notesDao.insertNotes(notes)
    }

    fun getNotes():LiveData<List<NotesModel>>{
        return notesDao.getNotes()
    }

}