package com.pankajkcodes.mvvmkotlinnotes

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "notes")
data class NotesModel(

    @PrimaryKey(autoGenerate = true)
    val id:Long,
    val title:String

)
