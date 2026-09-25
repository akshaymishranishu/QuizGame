package com.example.quizgame.domain

interface QuizRepository {
    suspend fun getQuiz(): Quiz
}