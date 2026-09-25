package com.example.quizgame.domain

import androidx.compose.runtime.Immutable

@Immutable
data class ScreenState(
    val quiz: Quiz,
    val currentQuestionIndex: Int,

    val isLoading: Boolean,
    val score: String,
    val isSubmitted: Boolean
) {
    companion object {
        val empty = ScreenState(
            quiz = Quiz.empty,
            currentQuestionIndex = 0,
            isLoading = false,
            score = "",
            isSubmitted = false
        )
    }
}