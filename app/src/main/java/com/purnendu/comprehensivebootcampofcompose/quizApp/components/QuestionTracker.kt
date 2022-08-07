package com.purnendu.comprehensivebootcampofcompose.quizApp.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.purnendu.comprehensivebootcampofcompose.quizApp.utils.AppColors

@Composable
fun QuestionTracker(counter: Int = 10, outOf: Int? = 100) {

    Text(
        text = buildAnnotatedString {

            withStyle(
                style = SpanStyle(
                    color = AppColors.mLightGray,
                    fontWeight = FontWeight.Bold,
                    fontSize = 27.sp
                )
            )
            {
                append("Question $counter/")
                withStyle(
                    style = SpanStyle(
                        color = AppColors.mLightGray,
                        fontWeight = FontWeight.Light, fontSize = 14.sp
                    )
                )
                {
                    append("$outOf")
                }

            }
        },
        modifier = Modifier.padding(20.dp)
    )

}