package com.example.quizgame.presentation

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizgame.domain.QuizOption

@Composable
@Preview
fun PreviewOption() {
    Option(
        quizOption = QuizOption(1, "dwdwfchjewbfjewhvfhjevfvwqfqwvfhjwqvfjwvqjffqwvfwqvfjhvwqfvqwved12vejh12vehjev1j2vej21vev12ev12jhvedcqwd dqwbd iudwq ud qw dub dqiwu "),
        isSelected = false,
        onClick = {}
    )
}

@Composable
fun Option(
    quizOption: QuizOption,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            modifier = Modifier,
            selected = isSelected,
            onClick = onClick,
            enabled = true
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = quizOption.option,
            fontSize = 12.sp,
            fontWeight = FontWeight(200)
        )
    }
}