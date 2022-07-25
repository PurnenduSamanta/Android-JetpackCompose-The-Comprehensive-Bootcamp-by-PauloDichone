package com.purnendu.comprehensivebootcampofcompose.noteApp.screen

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.purnendu.comprehensivebootcampofcompose.noteApp.data.NoteDataSource
import com.purnendu.comprehensivebootcampofcompose.noteApp.model.Note

class NoteViewModel : ViewModel() {

    private var noteList = mutableStateListOf<Note>()

    init {
        noteList.addAll(NoteDataSource().loadNotes())
    }

    fun addNote(note: Note) {
        noteList.add(note)
    }

    fun removeNote(note: Note) {
        noteList.remove(note)
    }

    fun getAllNotes(): List<Note> = noteList

}