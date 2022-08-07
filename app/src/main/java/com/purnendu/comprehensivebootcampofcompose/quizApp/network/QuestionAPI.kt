package com.purnendu.comprehensivebootcampofcompose.quizApp.network

import com.purnendu.comprehensivebootcampofcompose.quizApp.model.Questions
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface QuestionAPI {

    @GET("world.json")
    suspend fun getAllQuestions():Questions
}