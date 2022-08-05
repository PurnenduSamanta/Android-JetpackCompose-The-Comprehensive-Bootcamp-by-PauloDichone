package com.purnendu.comprehensivebootcampofcompose.noteApp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant
import java.util.*

@Entity(tableName = "Note_Table")
data class Note(
    @PrimaryKey
    val id:UUID= UUID.randomUUID(),
    @ColumnInfo(name = "Note_Title")
    val title:String,
    @ColumnInfo(name = "Note_Description")
    val description:String,
    @ColumnInfo(name = "Note_Date")
    val entryDate:Date=Date.from(Instant.now())
)
