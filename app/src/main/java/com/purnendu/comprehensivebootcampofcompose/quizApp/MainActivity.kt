package com.purnendu.comprehensivebootcampofcompose.quizApp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.purnendu.comprehensivebootcampofcompose.quizApp.screens.Home
import com.purnendu.comprehensivebootcampofcompose.quizApp.screens.QuestionsViewModel
import com.purnendu.comprehensivebootcampofcompose.ui.theme.ComprehensiveBootcampOfComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComprehensiveBootcampOfComposeTheme {

                val viewModel =viewModel<QuestionsViewModel>()
                Home(viewModel)
            }
        }

    }

}

