/// 할 일 목록 위젯
/// 1.시간
/// 2.할 일 제목
/// 3.할 일 상세 내용
/// 4.진행 시간
package com.example.todojetpack.taskManager.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.todojetpack.R
import com.example.todojetpack.taskManager.data.Task
import com.example.todojetpack.ui.theme.LightBlue
import com.example.todojetpack.ui.theme.LightGreen
import com.example.todojetpack.ui.theme.LightPurple

@Composable
fun TaskComponent(task: Task){
    /// 컨테이너 화면 색을 랜덤하게 설정한다.
    val taskColor = listOf(LightPurple, LightGreen, LightBlue).random()
    /// 모든 위젯은 가로로 배치한다.
    Row(
        modifier = Modifier.fillMaxWidth(), /// 위젯들을 가로 너비 꽉 차게 설정한다.
        horizontalArrangement = Arrangement.spacedBy(16.dp), /// 수평 배치하고 간격을 16dp로 설정한다.
        verticalAlignment = Alignment.CenterVertically, /// 위젯 중앙 정렬
    ) {
        Text(
            text = "${task.startTime}\n AM",
            fontFamily = FontFamily(Font(R.font.nunito_bold)),
            textAlign = TextAlign.Center, /// text 간의 배치는 중앙 정렬
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            /// 할 일 목록 컨테이너 사이에 박스 위젯(빈 위젯)으로 감싼다.
            Box(
                modifier = Modifier
                    .size(16.dp)
                    .clip(CircleShape)
                    .border(
                        BorderStroke(3.dp, Color.Black),
                        shape = CircleShape
                    )
            )
            /// 일종의 밑 선
            Divider(modifier = Modifier.width(6.dp), color = Color.Black)
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                /// 할 일 제목, 내용, 시작, 종료 시간 텍스트는 수직으로 배치한다.
                Column(
                    modifier = Modifier
                        .clip(RoundedCornerShape(14.dp))
                        .background(taskColor)
                        .weight(0.9f),
                    /// Flutter -> SizedBox(height: 8) 과 같은 역할을 한다.
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = task.title,
                        fontFamily = FontFamily(Font(R.font.nunito_bold)),
                        modifier = Modifier.padding(
                            start = 12.dp, // 왼쪽으로부터 12dp 띄움
                            top = 12.dp // 위쪽으로부터 12dp 간격 띄움
                        )
                    )

                    if(task.body != null){
                        Text(
                            text = task.body,
                            fontFamily = FontFamily(Font(R.font.nunito_bold)),
                            modifier = Modifier.padding(start = 12.dp),
                            color = Color.Gray
                        )
                    }
                    Text(
                        text = "${task.startTime} - ${task.endTime}",
                        fontFamily = FontFamily(Font(R.font.nunito_bold)),
                        modifier = Modifier.padding(
                            start = 12.dp,
                            bottom = 12.dp
                        )
                    )
                }
                Divider(
                    modifier = Modifier.width(6.dp).weight(0.1f),
                    color = Color.Black
                )
            }
        }
    }
}