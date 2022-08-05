package com.purnendu.comprehensivebootcampofcompose.noteApp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.purnendu.comprehensivebootcampofcompose.noteApp.model.Note
import com.purnendu.comprehensivebootcampofcompose.noteApp.util.DateConverter
import com.purnendu.comprehensivebootcampofcompose.noteApp.util.UUIDConverter

@Database(entities = [Note::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class, UUIDConverter::class)
abstract class NoteDatabase: RoomDatabase() {
    abstract fun noteDao(): NoteDatabaseDao
}