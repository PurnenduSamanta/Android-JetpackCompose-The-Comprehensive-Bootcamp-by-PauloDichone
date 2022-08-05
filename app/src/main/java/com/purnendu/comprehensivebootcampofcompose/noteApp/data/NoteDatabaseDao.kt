package com.purnendu.comprehensivebootcampofcompose.noteApp.data

import androidx.room.*
import com.purnendu.comprehensivebootcampofcompose.noteApp.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDatabaseDao {

    @Query("SELECT * from Note_Table")
    fun getNotes(): Flow<List<Note>>

    @Query("SELECT * from Note_Table where id =:id")
    suspend fun getNoteById(id: String): Note

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Note)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(note: Note)

    @Query("DELETE from Note_Table")
    suspend fun deleteAll()

    @Delete
    suspend fun deleteNote(note: Note)


}