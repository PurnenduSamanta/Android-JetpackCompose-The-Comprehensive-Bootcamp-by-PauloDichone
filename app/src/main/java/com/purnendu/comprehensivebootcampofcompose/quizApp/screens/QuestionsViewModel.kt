package com.purnendu.comprehensivebootcampofcompose.quizApp.screens

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.purnendu.comprehensivebootcampofcompose.quizApp.data.DataOrException
import com.purnendu.comprehensivebootcampofcompose.quizApp.model.QuestionItem
import com.purnendu.comprehensivebootcampofcompose.quizApp.repository.QuestionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuestionsViewModel @Inject constructor(private val repository: QuestionRepository) :
    ViewModel() {

    val data = mutableStateOf(
        DataOrException<ArrayList<QuestionItem>,
                Boolean, Exception>(null, true, Exception("")))


    init {
        getAllQuestions()
    }

    private fun getAllQuestions() {
        viewModelScope.launch {
            data.value.loading = true
            data.value = repository.getAllQuestions()
            if (!data.value.data.isNullOrEmpty())
                data.value.loading = false
        }
    }

    fun getTotalQuestionsNo(): Int? = data.value.data?.size


}