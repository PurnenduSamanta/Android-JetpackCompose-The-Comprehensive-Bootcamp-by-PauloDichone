package com.purnendu.comprehensivebootcampofcompose.quizApp.components


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.purnendu.comprehensivebootcampofcompose.quizApp.screens.QuestionsViewModel

@Composable
fun Questions(viewModel: QuestionsViewModel) {

    val questions = viewModel.data.value.data

    val questionIndex = remember {
        mutableStateOf(0)
    }

    if (viewModel.data.value.loading == true) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {

        val question = try {
            questions?.get(questionIndex.value)
        } catch (ex: Exception) {
            null
        }

        if (questions != null) {
            QuestionDisplay(
                questionItem = question!!,
                questionIndex = questionIndex.value,
                viewModel = viewModel
            )
            {
                if(questionIndex.value < questions.size)
                questionIndex.value = questionIndex.value + 1
            }
        }
    }
}
