package com.pankajkcodes.mvvmkotlinnotes

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val notesRepository: NotesRepository) : ViewModel(){

    fun getNotes(): LiveData<List<NotesModel>>{
        return notesRepository.getNotes()
    }



    fun insertNotes(note: NotesModel){
        viewModelScope.launch (Dispatchers.IO){
            notesRepository.insertNotes(note)
        }
    }

}