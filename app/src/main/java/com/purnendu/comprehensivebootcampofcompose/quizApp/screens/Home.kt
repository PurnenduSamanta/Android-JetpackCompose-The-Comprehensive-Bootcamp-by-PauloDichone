package com.purnendu.comprehensivebootcampofcompose.quizApp.screens

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.purnendu.comprehensivebootcampofcompose.quizApp.components.Questions

@Composable
fun Home(viewModel: QuestionsViewModel = viewModel()) = Questions(viewModel = viewModel)


