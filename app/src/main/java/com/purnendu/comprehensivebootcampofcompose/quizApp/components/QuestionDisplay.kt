package com.purnendu.comprehensivebootcampofcompose.quizApp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.purnendu.comprehensivebootcampofcompose.quizApp.model.QuestionItem
import com.purnendu.comprehensivebootcampofcompose.quizApp.screens.QuestionsViewModel
import com.purnendu.comprehensivebootcampofcompose.quizApp.utils.AppColors

@Composable
fun QuestionDisplay(
    questionItem: QuestionItem,
    questionIndex: Int,
    viewModel: QuestionsViewModel,
    onNextClicked: () -> Unit
) {

    val choiceState = remember(questionItem) {
        questionItem.choices
    }

    val answerState = remember(questionItem) {
        mutableStateOf<Int?>(null)
    }

    val correctAnswerState = remember(questionItem) {
        mutableStateOf<Boolean?>(null)
    }

    val updateAnswer: (Int) -> Unit =
        remember(questionItem)
        {
            {
                answerState.value = it
                correctAnswerState.value = choiceState[it] == questionItem.answer
            }

        }

    val pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        color = AppColors.mDarkPurple
    ) {

        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {

            if (questionIndex >= 3)
                ShowProgress(score = questionIndex)


            QuestionTracker(counter = questionIndex, outOf = viewModel.getTotalQuestionsNo())


            DrawDottedLine(pathEffect = pathEffect)

            Column {

                Text(
                    text = questionItem.question,
                    fontSize = 17.sp,
                    lineHeight = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = AppColors.mOffWhite,
                    modifier = Modifier
                        .padding(6.dp)
                        .align(alignment = Alignment.Start)
                        .fillMaxHeight(0.3f)
                )

                //choices
                choiceState.forEachIndexed { index, answerText ->

                    Row(
                        modifier = Modifier
                            .padding(3.dp)
                            .fillMaxWidth()
                            .height(45.dp)
                            .border(
                                width = 4.dp, brush = Brush.linearGradient(
                                    colors = listOf(
                                        AppColors.mOffDarkPurple,
                                        AppColors.mOffDarkPurple
                                    )
                                ),
                                shape = RoundedCornerShape(15.dp)
                            )
                            .background(Color.Transparent),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        RadioButton(
                            selected = (answerState.value == index),
                            onClick = {
                                updateAnswer(index)
                            },
                            modifier = Modifier.padding(start = 16.dp),
                            colors = RadioButtonDefaults.colors(
                                selectedColor = if (correctAnswerState.value == true )
                                    Color.Green.copy(alpha = 0.2f)
                                else
                                    Color.Red.copy(alpha = 0.2f)
                            )
                        )

                        val annotatedString = buildAnnotatedString {

                            withStyle(
                                style = SpanStyle(
                                    fontWeight = FontWeight.Light,
                                    color = if (correctAnswerState.value == true && index == answerState.value)
                                        Color.Green
                                    else if (correctAnswerState.value == false && index == answerState.value)
                                        Color.Red
                                    else
                                        AppColors.mOffWhite,
                                    fontSize = 17.sp
                                )
                            )
                            {
                                append(answerText)
                            }
                        }

                        Text(text = annotatedString, modifier = Modifier.padding(6.dp))


                    }

                }

                Button(modifier = Modifier
                    .padding(3.dp)
                    .align(alignment = Alignment.CenterHorizontally),
                    shape = RoundedCornerShape(34.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = AppColors.mLightBlue
                    ),
                    onClick = { onNextClicked() }) {

                    Text(
                        text = "Next", modifier = Modifier.padding(4.dp),
                        color = AppColors.mOffWhite,
                        fontSize = 17.sp
                    )

                }


            }

        }

    }

}