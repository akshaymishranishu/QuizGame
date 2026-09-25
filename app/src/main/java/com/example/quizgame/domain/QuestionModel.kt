package com.example.quizgame.domain

import androidx.compose.runtime.Immutable

@Immutable
data class Quiz(
    val questions: List<QuizQuestion>
) {
    companion object {
        val empty = Quiz(
            questions = emptyList()
        )
    }
}

@Immutable
data class QuizQuestion(
    val questionId: Int,
    val question: String,
    val options: List<QuizOption>,
    val answerId: Int
)

@Immutable
data class QuizOption(
    val optionId: Int,
    val option: String
)