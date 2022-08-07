package com.purnendu.comprehensivebootcampofcompose.quizApp.repository

import com.purnendu.comprehensivebootcampofcompose.quizApp.data.DataOrException
import com.purnendu.comprehensivebootcampofcompose.quizApp.model.QuestionItem
import com.purnendu.comprehensivebootcampofcompose.quizApp.network.QuestionAPI
import javax.inject.Inject

class QuestionRepository @Inject constructor(private val api: QuestionAPI) {


    private val dataOrException = DataOrException<ArrayList<QuestionItem>, Boolean, Exception>()

    suspend fun getAllQuestions():DataOrException<ArrayList<QuestionItem>, Boolean, Exception>
    {
        try {
            dataOrException.loading=true
            dataOrException.data=api.getAllQuestions()
            if(!dataOrException.data.isNullOrEmpty())
                dataOrException.loading=false
        }

        catch (exception:Exception)
        {
            dataOrException.e=exception
        }

        return dataOrException

    }


}