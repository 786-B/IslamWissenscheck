package com.ykp.islamwissenscheck.network


import com.ykp.islamwissenscheck.model.Question
import retrofit2.http.GET
import javax.inject.Singleton


@Singleton
interface QuestionApi {
    @GET("Fragen.json")
    suspend fun getAllQuestions(): Question
}