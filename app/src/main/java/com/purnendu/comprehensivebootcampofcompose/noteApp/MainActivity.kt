package com.purnendu.comprehensivebootcampofcompose.noteApp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.purnendu.comprehensivebootcampofcompose.noteApp.data.NoteDataSource
import com.purnendu.comprehensivebootcampofcompose.noteApp.screen.NoteScreen
import com.purnendu.comprehensivebootcampofcompose.noteApp.screen.NoteViewModel

import com.purnendu.comprehensivebootcampofcompose.ui.theme.ComprehensiveBootcampOfComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComprehensiveBootcampOfComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val noteViewModel: NoteViewModel by viewModels()
                    NotesApp(noteViewModel)
                }
            }
        }
    }
}

@Composable
fun NotesApp(noteViewModel: NoteViewModel = viewModel()) {

    val notesList = noteViewModel.getAllNotes()
    NoteScreen(notes = notesList,
        onAddNote = {
            noteViewModel.addNote(it)
        },
        onRemoveNote = {
            noteViewModel.removeNote(it)
        })


}