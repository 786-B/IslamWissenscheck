package com.ykp.islamwissenscheck.model

data class QuestionItem(
    val answer: String,
    val choices: List<String>,
    val question: String
)