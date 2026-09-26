package com.example.quizgame.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quizgame.domain.Quiz
import com.example.quizgame.domain.QuizRepository
import com.example.quizgame.domain.ScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import javax.inject.Inject

sealed interface UIEvent {
    data class Save(val optionId: Int): UIEvent
}

@HiltViewModel
class QuizGameViewModel @Inject constructor(
    private val quizRepository: QuizRepository
) : ViewModel() {

    private val _screenState = MutableStateFlow(ScreenState.empty)
    val screenState = _screenState.asStateFlow()

    private val selectedAnswerId: MutableMap<Int, Int> = mutableMapOf() //selected: question_id, option_id

    init {
        loadQuestions()
    }

    fun handleEvent(event: UIEvent) {
        when (event) {
            is UIEvent.Save -> saveAndNext(event.optionId)
        }
    }

    //on next click
    private fun saveAndNext(optionId: Int) {
        _screenState.update { state ->
            val isLastQuestion = state.quiz.questions.size == state.currentQuestionIndex + 1
            val currentQuestionId = state.quiz.questions[state.currentQuestionIndex].questionId
            val nextQuestionIndex = if(isLastQuestion) { state.currentQuestionIndex } else { state.currentQuestionIndex + 1 }
            selectedAnswerId[currentQuestionId] = optionId
            Log.d("akshay_test", selectedAnswerId.toString())

            val score = if(isLastQuestion) {
                val count = state.quiz.questions.count { ques ->
                    Log.d("akshay_test", "answer: ${selectedAnswerId[ques.questionId]}, correct: ${ques.answerId}")
                    selectedAnswerId[ques.questionId] == ques.answerId
                }
                "You have achieved $count out of ${state.quiz.questions.size} points!"
            } else ""

            state.copy(
                currentQuestionIndex = nextQuestionIndex,
                isSubmitted = isLastQuestion,
                score = score
            )
        }
    }

    private fun loadQuestions() {
        viewModelScope.launch(Dispatchers.IO) {
            _screenState.update {
                it.copy(
                    isLoading = true
                )
            }
            val quiz = quizRepository.getQuiz()
            _screenState.update {
                it.copy(
                    quiz = quiz,
                    isLoading = false
                )
            }
        }
    }
}