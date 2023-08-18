/// 환영 메시지 화면
/// 나의 이름, 나의 해야 할 일 설명란
package com.example.todojetpack.taskManager.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todojetpack.R
import com.example.todojetpack.ui.theme.LightGray

@Composable
@Preview
fun WelcomeMessageComponent(){
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)){
        Text(
            text = "Hi Jacob!!",
            fontFamily = FontFamily(Font(R.font.nunito_extrabold)),
            fontSize = 22.sp,
        )
        Text(
            text = "10 tasks for Saturday",
            fontFamily = FontFamily(Font(R.font.nunito_regular)),
            fontSize = 18.sp,
            color = LightGray
        )
    }
}