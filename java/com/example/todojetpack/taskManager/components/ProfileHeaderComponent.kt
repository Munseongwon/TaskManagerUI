/// 1. 맨 상단 프로필 사진
/// 2. 알림 확인 아이콘 설정

package com.example.todojetpack.taskManager.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Badge
import androidx.compose.material.BadgedBox
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todojetpack.R
import com.example.todojetpack.ui.theme.Orange

@Composable /// ProfileHeaderComponent() 구성 가능
@Preview /// 앱을 build -> emulator, android 기기 필요 없이 바로 미리 보기 화면이 가능하도록 함
fun ProfileHeaderComponent(){
    /// 모든 위젯(항목)들을 수평으로 배치한다.
    Row(
        modifier = Modifier.fillMaxWidth(), /// 화면의 너비(가로) 전체 채우기
        horizontalArrangement = Arrangement.SpaceBetween, /// 수평으로 배치하되 사이에 간격을 둔다.
        verticalAlignment = Alignment.CenterVertically, /// 위젯들을 중앙으로 정렬한다.
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile), /// 나의 profile.png 를 프로필 화면으로 사용
            contentDescription = "Profile Picture",
            modifier = Modifier /// 원형 모양의 프로필 화면 만들기
                .size(30.dp)
                .clip(CircleShape)
        )

        /// 알림 아이콘 및 알림 표시 위젯 제작
        BadgedBox(
            badge = {
            Badge(
                backgroundColor = Orange,
                contentColor = Color.White,
                modifier = Modifier.offset(y = 7.dp, x = (-6).dp)
            )
        },
            modifier = Modifier.padding(end = 16.dp)
        ) {
            Icon(imageVector = Icons.Filled.Notifications,
                 contentDescription = "Nofications"
            )
        }
    }
}