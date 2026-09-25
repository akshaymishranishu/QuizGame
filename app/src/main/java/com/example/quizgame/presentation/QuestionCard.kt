package com.example.quizgame.presentation

import android.widget.RadioGroup
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizgame.domain.QuizOption
import com.example.quizgame.domain.QuizQuestion

@Composable
@Preview
fun PreviewQuestionCard() {
    QuestionCard(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(horizontal = 28.dp),
        quizQuestion = QuizQuestion(
            questionId = 1,
            question = "gdwg efvyue iuwdbw fbeuwf fuewhf ffuweifhbew. fiwenf fniwf q ddwq",
            options = listOf(
                QuizOption(1, "dwdwf"),
                QuizOption(2, "fewwfwe"),
                QuizOption(3, "ewf2cew"),
                QuizOption(4, "vdsv3e d f32e"),
            ),
            answerId = 1
        ),
        selectedOptionId = 2,
        currentQuestionIndex = 0,
        totalQuestions = 10,
        onOptionSelected = {}
    )
}

@Composable
fun QuestionCard(
    modifier: Modifier = Modifier,
    quizQuestion: QuizQuestion,
    selectedOptionId: Int,
    currentQuestionIndex: Int,
    totalQuestions: Int,
    onOptionSelected: (Int) -> Unit
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(
            width = 2.dp,
            color = Color.Green
        )
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "${currentQuestionIndex+1}/$totalQuestions",
                fontSize = 20.sp,
                fontWeight = FontWeight(500),
                textAlign = TextAlign.Center
            )

            Text(
                modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
                text = "Question${currentQuestionIndex+1}: ${quizQuestion.question}",
                fontSize = 18.sp,
                fontWeight = FontWeight(250)
            )

            Spacer(modifier = Modifier.height(12.dp))

            quizQuestion.options.onEach { option ->
                Option(
                    quizOption = option,
                    isSelected = option.optionId == selectedOptionId,
                    onClick = { onOptionSelected(option.optionId) }
                )
            }
        }
    }
}