package com.example.quizgame.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.quizgame.domain.Quiz

@Composable
fun QuizScreen(
    modifier: Modifier = Modifier,
    viewModel: QuizGameViewModel
) {

    val screenState by viewModel.screenState.collectAsStateWithLifecycle()
    var selectedOptionId by remember { mutableIntStateOf(-1) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 28.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if(screenState.isLoading) {
            Loader()
        } else if(screenState.isSubmitted) {
            ResultBox(
                score = screenState.score
            )
        } else if(screenState.quiz.questions.isNotEmpty()) {
            QuestionCard(
                modifier = Modifier
                    .padding(top = 50.dp)
                    .fillMaxWidth()
                    .wrapContentHeight(),
                quizQuestion = screenState.quiz.questions[screenState.currentQuestionIndex],
                selectedOptionId = selectedOptionId,
                currentQuestionIndex = screenState.currentQuestionIndex,
                totalQuestions = screenState.quiz.questions.size,
                onOptionSelected = { optionId ->
                    selectedOptionId = optionId
                }
            )

            val onSave = remember(selectedOptionId) {
                {
                    viewModel.handleEvent(UIEvent.Save(selectedOptionId))
                }
            }

            ActionButton(
                modifier = Modifier.padding(top = 18.dp),
                text = if (screenState.currentQuestionIndex < screenState.quiz.questions.size - 1) "NEXT" else "SUBMIT",
                onClick = onSave
            )
        }
    }
}

@Composable
fun Loader() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun ResultBox(score: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Score: $score")
    }
}